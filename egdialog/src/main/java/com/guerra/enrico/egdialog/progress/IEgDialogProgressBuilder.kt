package com.guerra.enrico.egdialog.progress

import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

/**
 * Created by enrico
 * on 25/07/2018.
 */
interface IEgDialogProgressBuilder {
    fun setProgressLabel(@StringRes text: Int): EgDialogProgressBuilder
    fun setProgressLabel(text: CharSequence): EgDialogProgressBuilder

    fun setCancelActionText(@StringRes text: Int): EgDialogProgressBuilder
    fun setCancelActionText(text: CharSequence): EgDialogProgressBuilder

    fun setCancelActionBackgroundDrawable(@DrawableRes drawable: Int): EgDialogProgressBuilder
    fun setCancelActionBackgroundDrawable(drawable: Drawable): EgDialogProgressBuilder

    fun setOnCancelActionClickListener(listener: EgDialogProgressBuilder.OnActionClickListener): EgDialogProgressBuilder

    fun setCancelable(flag: Boolean) : EgDialogProgressBuilder

    fun build() : EgDialogProgress
}