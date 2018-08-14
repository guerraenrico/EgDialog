package com.guerra.enrico.egdialoglib

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.guerra.enrico.egdialog.common.EgDialog
import com.guerra.enrico.egdialog.common.EgDialogBuilder
import com.guerra.enrico.egdialog.progress.EgDialogProgressBuilder
import com.guerra.enrico.egdialoglib.models.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSimple.setOnClickListener {
            val builder = EgDialogBuilder(context = this)
                    .setTitle(R.string.app_name)
                    .setDescription("Lorem ipsum dolor sit ammet")
                    .setNegativeActionText("Cancel")
                    .setPositiveActionText("Confirm")
                    .setOnNegativeActionClickListener(object : EgDialogBuilder.OnActionClickListener {
                        override fun onClick(view: View, context: Context, dialog: EgDialog) {
                            dialog.dismiss()
                        }
                    })
                    .setOnPositiveActionClickListener(object : EgDialogBuilder.OnActionClickListener {
                        override fun onClick(view: View, context: Context, dialog: EgDialog) {
                            Toast.makeText(context, "Confirm", Toast.LENGTH_SHORT).show()
                        }

                    })
            builder.build().show()
        }

        buttonList.setOnClickListener {
            val builder = EgDialogBuilder(context = this)
                    .setTitle(R.string.app_name)
                    .setDescription("Lorem ipsum dolor sit ammet")
                    .setNegativeActionText("Cancel")
                    .setPositiveActionText("Confirm")
                    .setOnNegativeActionClickListener(object : EgDialogBuilder.OnActionClickListener {
                        override fun onClick(view: View, context: Context, dialog: EgDialog) {
                            dialog.dismiss()
                        }
                    })
                    .setSingleChoiceList(Person.getList(), { person: Person ->
                        person.name
                    }, { person: Person, _ ->
                        Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
                    }, 1)

            builder.build().show()
        }

        buttonLoading.setOnClickListener {
            val builder = EgDialogProgressBuilder(context = this)
                    .setProgressLabel("Loading...")

            builder.build().show()
        }
    }
}
