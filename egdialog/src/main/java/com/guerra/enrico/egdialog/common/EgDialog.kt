package com.guerra.enrico.egdialog.common

import android.os.Bundle
import android.view.ViewGroup
import com.guerra.enrico.egdialog.BaseDialog
import com.guerra.enrico.egdialog.R

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