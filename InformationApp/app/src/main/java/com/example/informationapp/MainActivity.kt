package com.example.informationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var nameEdTxtVar: EditText
    lateinit var idEdTxtVar: EditText
    lateinit var submitBtnVar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEdTxtVar = findViewById(R.id.nameEdTxtId)
        idEdTxtVar = findViewById(R.id.idEdTxtId)
        submitBtnVar = findViewById(R.id.submitBtnId)

        submitBtnVar.setOnClickListener{

        }
    }
}