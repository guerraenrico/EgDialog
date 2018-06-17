package com.guerra.enrico.egdialog

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.eg_dialog_main.view.*

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
        view.egDialogDescription.text = description
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
        view.egActionNegative.visibility = if (text.isNotEmpty()) View.VISIBLE else View.INVISIBLE
        view.egActionNegative.text = text
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