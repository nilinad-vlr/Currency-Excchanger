package com.example.android.currencyExchanger

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model = ExchangeModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private fun setViews() {
        btn0.setOnClickListener { updateTextFields("0") }
        btn1.setOnClickListener { updateTextFields("1") }
        btn2.setOnClickListener { updateTextFields("2") }
        btn3.setOnClickListener { updateTextFields("3") }
        btn4.setOnClickListener { updateTextFields("4") }
        btn5.setOnClickListener { updateTextFields("5") }
        btn6.setOnClickListener { updateTextFields("6") }
        btn7.setOnClickListener { updateTextFields("7") }
        btn8.setOnClickListener { updateTextFields("8") }
        btn9.setOnClickListener { updateTextFields("9") }
        btnAC.setOnClickListener { updateTextFields("AC") }
        btnBackSpace.setOnClickListener { updateTextFields("backspace") }
        btnSwap.setOnClickListener { swapCurrency() }

        updateTextFields("0")
    }


    private fun swapCurrency() {
        model.swapCurrency()
        updateTextFields("AC")

        when (model.inputCurrency) {
            ExchangeModel.Currency.RUB -> {
                firstFlag.setImageResource(R.drawable.rus_flag_72)
                firstValue.setText("RUB")
            }

            ExchangeModel.Currency.USD -> {
                firstFlag.setImageResource(R.drawable.usa_flag_72)
                firstValue.setText("USD")
            }
        }

        when (model.outputCurrency){
            ExchangeModel.Currency.RUB -> {
                secondFlag.setImageResource(R.drawable.rus_flag_72)
                secondValue.setText("RUB")
        }
            ExchangeModel.Currency.USD -> {
                secondFlag.setImageResource(R.drawable.usa_flag_72)
                secondValue.setText("USD")
            }
        }
    }


    private fun updateTextFields(str: String) {
        val modelResult = model.update(str)
        inputText.text = modelResult.first
        outputText.text = modelResult.second
    }
}




