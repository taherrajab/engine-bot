package com.example.calculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CalculatorViewModel : ViewModel() {

    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double> get() = _result

    private val api = Retrofit.Builder()
        .baseUrl("https://<YOUR_BACKEND_URL>") // Ensured to use HTTPS
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CalculatorApi::class.java)

    fun calculate(expression: String) {
        viewModelScope.launch {
            try {
                val response = api.calculate(ExpressionRequest(expression))
                if (response.success) {
                    _result.value = response.result
                }
            } catch (e: Exception) {
                _result.value = null // Handle error case
            }
        }
    }
}
