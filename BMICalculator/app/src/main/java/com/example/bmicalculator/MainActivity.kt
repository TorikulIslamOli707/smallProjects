package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Creating variable for xml fields.
    lateinit var weightEdTxtVar: EditText
    lateinit var heightFtEdTxtVar: EditText
    lateinit var heightInchEdTxtVar: EditText
    lateinit var submitBtnVar: Button
    lateinit var resultTxtVar: TextView
    lateinit var resetBtnVar: Button

    var weight = 0
    var heightFt = 0
    var heightInch = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing the xml id's to the variables
        weightEdTxtVar = findViewById(R.id.weightEdTxtId)
        heightFtEdTxtVar = findViewById(R.id.heightFtEdTxtId)
        heightInchEdTxtVar = findViewById(R.id.heightInchEdTxtId)
        submitBtnVar = findViewById(R.id.submitBtnId)
        resultTxtVar = findViewById(R.id.resultTxtId)
        resetBtnVar = findViewById(R.id.resetBtnId)

        // calling hint disappear function to hide the text by clicking on the field.
        hintDisappear(weightEdTxtVar, "Enter your weight(kg)")
        hintDisappear(heightFtEdTxtVar, "Enter your height(ft)")
        hintDisappear(heightInchEdTxtVar, "Enter your height(Inch)")

        submitBtnVar.setOnClickListener{
            actionPerformed()
        }

        resetBtnVar.setOnClickListener{
            weightEdTxtVar.setText("")
            weightEdTxtVar.clearFocus()
            heightFtEdTxtVar.setText("")
            heightFtEdTxtVar.clearFocus()
            heightInchEdTxtVar.setText("")
            heightInchEdTxtVar.clearFocus()
            resultTxtVar.text = ""
           /* weightEdTxtVar.hint = "Enter your weight(kg)"
            heightFtEdTxtVar.hint = "Enter your height(ft)"
            heightInchEdTxtVar.hint = "Enter your height(Inch)"*/
        }

    }

    // hint disappear function
    private fun hintDisappear(hintField: EditText, hintTxt: String){
        hintField.setOnFocusChangeListener{view, focus->
            if (focus){
                hintField.hint = ""
            }else{
                hintField.hint = hintTxt
            }
        }
    }

    private fun actionPerformed(){
        if (weightEdTxtVar.text.toString().isNotEmpty())
            weight = weightEdTxtVar.text.toString().toInt()
        else
            weightEdTxtVar.error = "Required Field"

        val heightFtStr: String = heightFtEdTxtVar.text.toString()
        if (heightFtStr.isNotEmpty())
            heightFt = heightFtStr.toInt()
        else
            heightFtEdTxtVar.error = "Required Field"

        val heightInchStr: String = heightInchEdTxtVar.text.toString()
        if (heightInchStr.isNotEmpty())
            heightInch = heightInchStr.toInt()
        else
            heightInchEdTxtVar.error = "Required Field"

        val feetInch = heightFt * 12 + heightInch
        val heightCM = feetInch * 2.53
        val heightMM = heightCM / 100
        val bmi = weight / (heightMM * heightMM)

        if (bmi > 25){
            resultTxtVar.text = "You're unhealthy"
            resultTxtVar.setBackgroundColor(resources.getColor(R.color.red))
        }else if (bmi < 18) {
            resultTxtVar.text = "Your're underweight"
            resultTxtVar.setBackgroundColor(resources.getColor(R.color.yellow))
        }else {
            resultTxtVar.text = "You're healthy"
            resultTxtVar.setBackgroundColor(resources.getColor(R.color.green))
        }
    }
}