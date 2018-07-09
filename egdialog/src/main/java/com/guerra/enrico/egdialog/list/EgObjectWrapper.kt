package com.guerra.enrico.egdialog.list

/**
 * Created by enrico
 * on 09/07/2018.
 */
class EgObjectWrapper<T>(val item: T, var selected: Boolean = false) {
    companion object {
        fun <T> getWrapperList(list: List<T>): List<EgObjectWrapper<T>> {
            return list.map {
                EgObjectWrapper(it)
            }
        }
    }
}