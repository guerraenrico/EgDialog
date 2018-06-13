package com.guerra.enrico.egdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.eg_dialog_main.view.*

/**
 * Created by enrico
 * on 10/06/2018.
 */
class EgDialogBuilder(var context: Context, root: ViewGroup?= null) {
    val view: View
    val themeId = R.style.EgDialogStyle
    init {
        val inflater = LayoutInflater.from(context)
        view = inflater.inflate(R.layout.eg_dialog_main,  root)
    }

    fun setTitle(title: CharSequence?) : EgDialogBuilder {
        view.egDialogTitle.text = title
        return this
    }

    fun setDescription(description: CharSequence?): EgDialogBuilder {
        view.egDialogDescription.text = description
        return this
    }

    fun setPositiveActionText(textActionPositive: CharSequence): EgDialogBuilder {
        view.egActionPositive.text = textActionPositive
        return this
    }

    fun setNegativeActionText(textActionNegative: CharSequence): EgDialogBuilder {
        view.egActionNegative.visibility = if (textActionNegative !== "") View.VISIBLE else View.INVISIBLE
        view.egActionNegative.text = textActionNegative
        return this
    }

    fun setOnActionPositiveClickListener(listener: View.OnClickListener): EgDialogBuilder {
        view.egActionPositive.setOnClickListener(listener)
        return this
    }

    fun setOnActionNegativeClickListener(listener: View.OnClickListener): EgDialogBuilder {
        view.egActionNegative.setOnClickListener(listener)
        return this
    }

    fun build() : EgDialog {
        return EgDialog(this)
    }



}