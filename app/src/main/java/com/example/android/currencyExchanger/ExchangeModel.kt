package com.example.android.currencyExchanger

import kotlin.math.round

class ExchangeModel {

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
        return Pair(exchangeSum, convert(exchangeSum))
    }

    private fun convert(string: String): String {
        val divided = string.toDouble() / 74
        val rounded = divided.round(2)
        return rounded.toString()
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}
