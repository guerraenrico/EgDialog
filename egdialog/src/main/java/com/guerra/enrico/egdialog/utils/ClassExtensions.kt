package com.guerra.enrico.egdialog.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Created by enrico
 * on 09/07/2018.
 */

fun ViewGroup.inflate(@LayoutRes layoutId : Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this,false)
}