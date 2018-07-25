package com.guerra.enrico.egdialog.progress

import android.os.Bundle
import android.view.ViewGroup
import com.guerra.enrico.egdialog.BaseDialog
import com.guerra.enrico.egdialog.R

/**
 * Created by enrico
 * on 25/07/2018.
 */
class EgDialogProgress (val builder: EgDialogProgressBuilder) : BaseDialog(builder.context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(builder.view)
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawableResource(R.drawable.background_window_eg_dialog)
    }
}