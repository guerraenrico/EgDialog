package com.guerra.enrico.egdialog

import android.os.Bundle
import android.view.ViewGroup

/**
 * Created by enrico
 * on 10/06/2018.
 */
class EgDialog(val builder: EgDialogBuilder) : BaseDialog(builder.context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(builder.view)
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawableResource(R.drawable.background_window_eg_dialog)
    }
}