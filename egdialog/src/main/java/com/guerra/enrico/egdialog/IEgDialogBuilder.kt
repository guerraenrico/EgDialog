package com.guerra.enrico.egdialog

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by enrico
 * on 16/06/2018.
 */
interface IEgDialogBuilder {
    fun setTitle(@StringRes title: Int) : EgDialogBuilder
    fun setTitle(title: CharSequence) : EgDialogBuilder

    fun setDescription(@StringRes description: Int): EgDialogBuilder
    fun setDescription(description: CharSequence): EgDialogBuilder

    fun setPositiveActionText(@StringRes text: Int): EgDialogBuilder
    fun setPositiveActionText(text: CharSequence): EgDialogBuilder

    fun setPositiveActionBackgroundDrawable(@DrawableRes drawable: Int): EgDialogBuilder
    fun setPositiveActionBackgroundDrawable(drawable: Drawable): EgDialogBuilder

    fun setNegativeActionText(@StringRes text: Int): EgDialogBuilder
    fun setNegativeActionText(text: CharSequence): EgDialogBuilder

    fun setNegativeActionBackgroundDrawable(@DrawableRes drawable: Int): EgDialogBuilder
    fun setNegativeActionBackgroundDrawable(drawable: Drawable): EgDialogBuilder

    fun setOnPositiveActionClickListener(listener: EgDialogBuilder.OnActionClickListener): EgDialogBuilder

    fun setOnNegativeActionClickListener(listener: EgDialogBuilder.OnActionClickListener): EgDialogBuilder

    fun <T> setSingleChoiceList(list: List<T>, getItemDescription: (T) -> String, onItemSelected: (T, Int) -> Unit, positionSelectedItem: Int = -1): EgDialogBuilder

    fun setCancelable(flag: Boolean) : EgDialogBuilder

    fun build() : EgDialog
}