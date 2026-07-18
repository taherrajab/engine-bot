package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception
import java.util.regex.Pattern

class CalculatorViewModel : ViewModel() {
    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int> get() = _result

    fun calculate(input: String) {
        if (isValidInput(input)) {
            _result.value = evaluateExpression(input)
        } else {
            _result.value = 0 // Handle invalid input
        }
    }

    private fun evaluateExpression(input: String): Int {
        return input.length // Placeholder logic for demonstration
    }

    private fun isValidInput(input: String): Boolean {
        val pattern = Pattern.compile("^[0-9+\-*/.() ]+$")
        return pattern.matcher(input).matches()
    }
}
