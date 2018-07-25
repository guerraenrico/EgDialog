package com.guerra.enrico.egdialog.progress

import android.support.annotation.StringRes
import com.guerra.enrico.egdialog.common.EgDialog

/**
 * Created by enrico
 * on 25/07/2018.
 */
interface IEgDialogProgressBuilder {
    fun setProgress(indeteminate: Boolean = true): EgDialogProgressBuilder

    fun setProgressLabel(@StringRes text: Int): EgDialogProgressBuilder
    fun setProgressLabel(text: CharSequence): EgDialogProgressBuilder

    fun build() : EgDialogProgress
}