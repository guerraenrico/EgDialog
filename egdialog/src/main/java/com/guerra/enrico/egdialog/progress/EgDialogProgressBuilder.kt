package com.guerra.enrico.egdialog.progress

import android.content.Context
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

    override fun setProgress(indeteminate: Boolean): EgDialogProgressBuilder {
        val inflater = LayoutInflater.from(context)

        return this
    }

    override fun setProgressLabel(text: Int): EgDialogProgressBuilder {
        return setProgressLabel(getResourcesString(text))
    }

    override fun setProgressLabel(text: CharSequence): EgDialogProgressBuilder {
        view.progressLabel.text = text
        return this
    }

    override fun build() : EgDialogProgress {
        dialog = EgDialogProgress(this)
        return dialog
    }

    private fun getResourcesString(@StringRes stringId: Int) : String = context.getString(stringId)
}