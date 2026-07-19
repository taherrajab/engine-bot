package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _display = MutableLiveData("0")
    val display: LiveData<String> get() = _display

    private var operand1: Double? = null
    private var operand2: Double? = null
    private var operator: String? = null
    private var currentInput = StringBuilder()
    private var newInput = true

    fun onDigit(digit: String) {
        if (newInput) { currentInput.clear(); newInput = false }
        currentInput.append(digit)
        _display.value = currentInput.toString()
    }

    fun onOperator(op: String) {
        operand1 = currentInput.toString().toDoubleOrNull() ?: operand1
        operator = op
        newInput = true
    }

    fun onEquals() {
        operand2 = currentInput.toString().toDoubleOrNull() ?: return
        val result = when (operator) {
            "+" -> operand1!! + operand2!!
            "-" -> operand1!! - operand2!!
            "*" -> operand1!! * operand2!!
            "/" -> if (operand2 != 0.0) operand1!! / operand2!! else Double.NaN
            else -> return
        }
        val formatted = if (result == result.toLong().toDouble()) result.toLong().toString() else result.toString()
        _display.value = formatted
        currentInput.clear()
        currentInput.append(formatted)
        newInput = true
    }

    fun onClear() {
        currentInput.clear()
        operand1 = null
        operand2 = null
        operator = null
        newInput = true
        _display.value = "0"
    }
}
