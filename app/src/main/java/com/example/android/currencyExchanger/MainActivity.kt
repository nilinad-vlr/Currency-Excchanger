package com.example.android.currencyExchanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText: TextView = findViewById<TextView>(R.id.inputText)
        val outputText: TextView = findViewById<TextView>(R.id.outputText)

        btn0.setOnClickListener { setTextFields("0") }
        btn1.setOnClickListener { setTextFields("1") }
        btn2.setOnClickListener { setTextFields("2") }
        btn3.setOnClickListener { setTextFields("3") }
        btn4.setOnClickListener { setTextFields("4") }
        btn5.setOnClickListener { setTextFields("5") }
        btn6.setOnClickListener { setTextFields("6") }
        btn7.setOnClickListener { setTextFields("7") }
        btn8.setOnClickListener { setTextFields("8") }
        btn9.setOnClickListener { setTextFields("9") }
        btnAC.setOnClickListener {
            inputText.text = ""
            outputText.text = ""
        }
        btnBackSpace.setOnClickListener {
            val str = inputText.text.toString()
            if (str.isNotEmpty()) {
                inputText.text = str.substring(0, str.length - 1)
            } else {
                inputText.text = "0"
            }
            outputText.text = ""
        }
    }

    fun setTextFields(str: String) {
        inputText.text = inputText.text.toString().plus(str)
    }
}
