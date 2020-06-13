package com.example.android.currencyExchanger

import java.util.*
import kotlin.math.round

class ExchangeModel {

    enum class Currency {
        USD, RUB
    }

    var inputCurrency = ExchangeModel.Currency.RUB
    var outputCurrency = ExchangeModel.Currency.USD

    private var exchangeSum = ""
        set(value) {

            if (value == "AC") {
                field = "0"
                return
            }

            if (value == "backspace") {
                if (exchangeSum.isNotEmpty()) field = exchangeSum.dropLast(1)
                if (exchangeSum.isEmpty()) field = "0"
                return
            }

            if (exchangeSum.length >= 8) return

            if (value == "0" && exchangeSum == "0") {
                field = "0"
                return
            }

            if (exchangeSum == "0") {
                field = value
                return
            }

            field = exchangeSum + value
        }

    public fun update(char: String): Pair<String, String> {
        exchangeSum = char
        return Pair(exchangeSum, convert(exchangeSum, inputCurrency))
    }

    public fun swapCurrency() {
        val cacheInputCurrency = inputCurrency
        inputCurrency = outputCurrency
        outputCurrency = cacheInputCurrency
    }

    private fun convert(string: String, currency: Currency): String {
        when (currency) {
            Currency.RUB -> {
                val divided = string.toDouble() / 74
                val rounded = divided.round(2)
                return rounded.toString()
            }

            Currency.USD -> {
                val divided = string.toDouble() * 74
                val rounded = divided.round(2)
                return rounded.toString()
            }


        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}
