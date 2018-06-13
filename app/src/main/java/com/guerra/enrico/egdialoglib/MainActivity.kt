package com.guerra.enrico.egdialoglib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.guerra.enrico.egdialog.EgDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpen.setOnClickListener {
            val builder = EgDialogBuilder(context = this)
                    .setTitle("Title")
                    .setDescription("Lorem ipsum dolor sit ammet")
                    .setNegativeActionText("Cancel")
                    .setPositiveActionText("Confirm")
            builder.build().show()
        }

    }
}
