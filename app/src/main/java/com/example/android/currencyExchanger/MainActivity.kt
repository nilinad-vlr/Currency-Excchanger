package com.example.android.currencyExchanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById<EditText>(R.id.editTextValue)
        val textView1: TextView = findViewById<TextView>(R.id.rusValue)
        val textView2: TextView = findViewById<TextView>(R.id.usaValue)

        editText.afterTextChanged {
            if (it.isNotEmpty()) {
                textView1.text = it.toFloat().toString()
                textView2.text = (it.toFloat() / 74).toString()
            } else {
                textView1.text = "0"
                textView2.text = "0"
            }
        }
    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }
}