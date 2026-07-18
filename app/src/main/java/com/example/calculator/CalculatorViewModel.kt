package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _displayString = MutableLiveData<String>()
    val displayString: LiveData<String> get() = _displayString

    private var operand1: Double? = null
    private var operand2: Double? = null
    private var operator: String? = null

    init {
        _displayString.value = "0"
    }

    fun onNumberClicked(number: String) {
        val currentDisplay = _displayString.value
        if (currentDisplay == "0") {
            _displayString.value = number
        } else {
            _displayString.value += number
        }
    }

    fun onOperatorClicked(op: String) {
        operand1 = _displayString.value?.toDoubleOrNull()
        operator = op
        _displayString.value = "0"
    }

    fun onEqualsClicked() {
        operand2 = _displayString.value?.toDoubleOrNull()
        val result = when (operator) {
            "+" -> operand1!! + operand2!!
            "-" -> operand1!! - operand2!!
            "*" -> operand1!! * operand2!!
            "/" -> operand1!! / operand2!!
            else -> 0.0
        }
        _displayString.value = result.toString()
        operand1 = null
        operand2 = null
        operator = null
    }
}
