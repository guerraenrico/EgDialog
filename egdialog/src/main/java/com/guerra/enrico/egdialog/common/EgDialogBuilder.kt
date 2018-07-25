package com.guerra.enrico.egdialog.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.guerra.enrico.egdialog.R
import com.guerra.enrico.egdialog.list.EgDividerItemDecoration
import com.guerra.enrico.egdialog.list.EgListAdapter
import com.guerra.enrico.egdialog.list.EgObjectWrapper
import kotlinx.android.synthetic.main.eg_dialog_main.view.*
import kotlinx.android.synthetic.main.eg_dialog_partial_list.view.*

/**
 * Created by enrico
 * on 10/06/2018.
 */
class EgDialogBuilder(var context: Context) : IEgDialogBuilder {
    val view: View
    private lateinit var dialog: EgDialog
    private var cancelable = true

    init {
        val inflater = LayoutInflater.from(context)
        view = inflater.inflate(R.layout.eg_dialog_main,  null)
    }

    override fun setTitle(title: Int): EgDialogBuilder {
        return setTitle(getResourcesString(title))
    }

    override fun setTitle(title: CharSequence) : EgDialogBuilder {
        view.egDialogTitle.text = title
        return this
    }

    override fun setDescription(description: Int): EgDialogBuilder {
        return setDescription(getResourcesString(description))
    }

    override fun setDescription(description: CharSequence): EgDialogBuilder {
        if (description.isNotEmpty()) {
            view.egDialogDescription.visibility = View.VISIBLE
            view.egDialogDescription.text = description
        }
        return this
    }

    override fun setPositiveActionText(text: Int): EgDialogBuilder {
        return setPositiveActionText(getResourcesString(text))
    }

    override fun setPositiveActionText(text: CharSequence): EgDialogBuilder {
        view.egActionPositive.text = text
        return this
    }

    override fun setPositiveActionBackgroundDrawable(drawable: Int): EgDialogBuilder {
        return setPositiveActionBackgroundDrawable(context.resources.getDrawable(drawable, context.theme))
    }

    override fun setPositiveActionBackgroundDrawable(drawable: Drawable): EgDialogBuilder {
        view.egActionPositive.background = drawable
        return this
    }

    override fun setNegativeActionText(text: Int): EgDialogBuilder {
        return setNegativeActionText(getResourcesString(text))
    }

    override fun setNegativeActionText(text: CharSequence): EgDialogBuilder {
        if (text.isNotEmpty()) {
            view.egActionNegative.visibility = View.VISIBLE
            view.egActionNegative.text = text
        } else {
            view.egActionNegative.visibility = View.INVISIBLE
        }
        return this
    }

    override fun setNegativeActionBackgroundDrawable(drawable: Int): EgDialogBuilder {
        return setNegativeActionBackgroundDrawable(context.resources.getDrawable(drawable, context.theme))
    }

    override fun setNegativeActionBackgroundDrawable(drawable: Drawable): EgDialogBuilder {
        view.egActionNegative.background = drawable
        return this
    }

    override fun setOnPositiveActionClickListener(listener: OnActionClickListener): EgDialogBuilder {
        view.egActionPositive.setOnClickListener {
            if (!this::dialog.isInitialized) {
                throw InstantiationException("Dialog is not initialized. Need to cal method build")
            }
            listener.onClick(it, context, dialog)
        }
        return this
    }

    override fun setOnNegativeActionClickListener(listener: OnActionClickListener): EgDialogBuilder {
        view.egActionNegative.setOnClickListener {
            if (!this::dialog.isInitialized) {
                throw InstantiationException("Dialog is not initialized. Need to cal method build")
            }
            listener.onClick(it, context, dialog)
        }
        return this
    }

    override fun <T> setSingleChoiceList(list: List<T>, getItemDescription: (T) -> String, onItemSelected: (T, Int) -> Unit, positionSelectedItem: Int): EgDialogBuilder {
        val inflater = LayoutInflater.from(context)
        view.egContentCustomView.visibility = View.VISIBLE
        view.egContentCustomView.addView(inflater.inflate(R.layout.eg_dialog_partial_list, null) as LinearLayout?)

        val wrapperList = EgObjectWrapper.getWrapperList(list)
        if (positionSelectedItem != -1) {
            wrapperList[positionSelectedItem].selected = true
        }

        val adapter = EgListAdapter(wrapperList.toMutableList(), getItemDescription) {
            egObjectWrapper: EgObjectWrapper<T>, position: Int ->
            run {
                val adapterList = getRecyclerViewAdapter<T>().list
                adapterList.forEach { it.selected = false }
                egObjectWrapper.selected = true
                getRecyclerViewAdapter<T>().notifyDataSetChanged()

                view.egActionPositive.setOnClickListener {
                    onItemSelected(egObjectWrapper.item, position)
                    dialog.dismiss()
                }
            }
        }

        view.egActionPositive.setOnClickListener {
            if (positionSelectedItem != -1) {
                onItemSelected(wrapperList[positionSelectedItem].item, positionSelectedItem)
                dialog.dismiss()
            }
        }

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.egDialogRecycler.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(EgDividerItemDecoration(this.context, layoutManager.orientation))
            this.itemAnimator = DefaultItemAnimator()
            this.adapter = adapter
        }
        adapter.notifyDataSetChanged()
        return this
    }

    private fun <T> getRecyclerViewAdapter(): EgListAdapter<T>{
        @Suppress("UNCHECKED_CAST")
        return view.egDialogRecycler.adapter as EgListAdapter<T>
    }

    override fun setCancelable(flag: Boolean): EgDialogBuilder {
        cancelable = flag
        return this
    }

    override fun build() : EgDialog {
        dialog = EgDialog(this)
        dialog.setCancelable(cancelable)
        return dialog
    }

    private fun getResourcesString(@StringRes stringId: Int) : String = context.getString(stringId)

    interface OnActionClickListener{
        fun onClick(view: View, context: Context, dialog: EgDialog)
    }
}