package com.guerra.enrico.egdialog.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.guerra.enrico.egdialog.R
import com.guerra.enrico.egdialog.utils.inflate
import kotlinx.android.synthetic.main.eg_dialog_item_single_choice.view.*

/**
 * Created by enrico
 * on 09/07/2018.
 */
class EgListAdapter<T>(
        var list: MutableList<EgObjectWrapper<T>>,
        val getItemDescription: (T) -> String,
        val itemClickListener: (EgObjectWrapper<T>, Int) -> Unit
): RecyclerView.Adapter<EgListAdapter.Holder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder<T>(parent.inflate(R.layout.eg_dialog_item_single_choice))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder<T>, position: Int) {
        holder.bind(list[position], position, getItemDescription, itemClickListener)
    }

    class Holder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemWrapper: EgObjectWrapper<T>, position: Int, getItemDescription: (T) -> String, itemClickListener : (EgObjectWrapper<T>, Int) -> Unit) = with(itemView){
            egDialogSingleChoiceDescription.text = getItemDescription(itemWrapper.item)
            egDialogSingleChoiceRadioSelect.isChecked = itemWrapper.selected
            egDialogSingleChoiceRadioSelect.setOnClickListener { itemClickListener(itemWrapper, position)  }
            setOnClickListener { itemClickListener(itemWrapper, position) }
        }
    }
}