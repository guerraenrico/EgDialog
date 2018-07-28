package com.guerra.enrico.egdialog.progress

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import com.guerra.enrico.egdialog.R
import kotlinx.android.synthetic.main.eg_dialog_progress_main.view.*

/**
 * Created by enrico
 * on 25/07/2018.
 */
class EgDialogProgressBuilder (var context: Context) : IEgDialogProgressBuilder {
    val view: View
    private lateinit var dialog: EgDialogProgress
    private var cancelable = true

    init {
        val inflater = LayoutInflater.from(context)
        view = inflater.inflate(R.layout.eg_dialog_progress_main,  null)
    }

    override fun setProgressLabel(text: Int): EgDialogProgressBuilder {
        return setProgressLabel(getResourcesString(text))
    }

    override fun setProgressLabel(text: CharSequence): EgDialogProgressBuilder {
        view.progressLabel.text = text
        return this
    }


    override fun setCancelActionText(text: Int): EgDialogProgressBuilder {
        return setCancelActionText(getResourcesString(text))
    }

    override fun setCancelActionText(text: CharSequence): EgDialogProgressBuilder {
        if (text.isNotEmpty()) {
            view.egActionCancel.visibility = View.VISIBLE
            view.egActionCancel.text = text
        } else {
            view.egActionCancel.visibility = View.GONE
        }
        return this
    }

    override fun setCancelActionBackgroundDrawable(drawable: Int): EgDialogProgressBuilder {
        return setCancelActionBackgroundDrawable(getResourcesDrawable(drawable))
    }

    override fun setCancelActionBackgroundDrawable(drawable: Drawable): EgDialogProgressBuilder {
        view.egActionCancel.background = drawable
        return this
    }

    override fun setOnCancelActionClickListener(listener: OnActionClickListener): EgDialogProgressBuilder {
        view.egActionCancel.setOnClickListener {
            if (!this::dialog.isInitialized) {
                throw InstantiationException("Dialog is not initialized. Need to cal method build")
            }
            listener.onClick(it, context, dialog)
        }
        return this
    }

    override fun setCancelable(flag: Boolean): EgDialogProgressBuilder {
        cancelable = flag
        return this
    }

    override fun build() : EgDialogProgress {
        dialog = EgDialogProgress(this)
        dialog.setCancelable(cancelable)
        return dialog
    }

    private fun getResourcesString(@StringRes stringId: Int) : String = context.getString(stringId)

    private fun getResourcesDrawable(@DrawableRes drawableId: Int): Drawable = context.resources.getDrawable(drawableId, context.theme)

    interface OnActionClickListener{
        fun onClick(view: View, context: Context, dialog: EgDialogProgress)
    }
}