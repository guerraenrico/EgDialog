package com.guerra.enrico.egdialog

import android.support.annotation.StringRes
import android.view.View

/**
 * Created by enrico
 * on 16/06/2018.
 */
interface IEgDialogBuilder {
    fun setTitle(@StringRes title: Int) : EgDialogBuilder
    fun setTitle(title: CharSequence) : EgDialogBuilder

    fun setDescription(@StringRes description: Int): EgDialogBuilder
    fun setDescription(description: CharSequence): EgDialogBuilder

    fun setPositiveActionText(@StringRes textActionPositive: Int): EgDialogBuilder
    fun setPositiveActionText(textActionPositive: CharSequence): EgDialogBuilder

    fun setNegativeActionText(@StringRes textActionNegative: Int): EgDialogBuilder
    fun setNegativeActionText(textActionNegative: CharSequence): EgDialogBuilder

    fun setOnActionPositiveClickListener(listener: View.OnClickListener): EgDialogBuilder

    fun setOnActionNegativeClickListener(listener: View.OnClickListener): EgDialogBuilder

    fun build() : EgDialog
}