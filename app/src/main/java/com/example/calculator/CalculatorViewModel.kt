package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _displayString = MutableLiveData<String>("0")
    val displayString: LiveData<String> get() = _displayString

    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String? = null

    fun onNumberClicked(number: String) {
        _displayString.value = (_displayString.value ?: "0") + number
    }

    fun onOperatorClicked(op: String) {
        operator = op
        operand1 = _displayString.value?.toDouble() ?: 0.0
        _displayString.value = ""
    }

    fun onEqualsClicked() {
        operand2 = _displayString.value?.toDouble() ?: 0.0
        val result = when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
        _displayString.value = result.toString()
    }
}
