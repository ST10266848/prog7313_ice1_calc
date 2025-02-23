package com.prog7313.ice1basiccalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText1: EditText
    private lateinit var inputEditText2: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText1 = findViewById(R.id.inputEditText1)
        inputEditText2 = findViewById(R.id.inputEditText2)
        resultTextView = findViewById(R.id.resultTextView)

        findViewById<Button>(R.id.addButton).setOnClickListener { performOperation('+') }
        findViewById<Button>(R.id.subtractButton).setOnClickListener { performOperation('-') }
        findViewById<Button>(R.id.multiplyButton).setOnClickListener { performOperation('*') }
        findViewById<Button>(R.id.divideButton).setOnClickListener { performOperation('/') }
    }

    private fun performOperation(operator: Char) {
        val num1Str = inputEditText1.text.toString()
        val num2Str = inputEditText2.text.toString()

        if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            val result = when (operator) {
                '+' -> num1 + num2
                '-' -> num1 - num2
                '*' -> num1 * num2
                '/' -> if (num2 != 0.0) num1 / num2 else Double.NaN // Handle division by zero
                else -> Double.NaN
            }

            if(result.isNaN()){
                resultTextView.text = "Error: Division by zero"
            }else{
                resultTextView.text = "Result: $result"
            }

        } else {
            resultTextView.text = "Please enter both numbers"
        }
    }
}

