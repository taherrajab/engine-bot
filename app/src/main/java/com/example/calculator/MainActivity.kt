package com.example.calculator

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        viewModel.result.observe(this) { result ->
            binding.tvDisplay.text = result.toString()
        }
    }

    private fun setupListeners() {
        binding.btn0.setOnClickListener { appendToExpression("0") }
        binding.btn1.setOnClickListener { appendToExpression("1") }
        binding.btn2.setOnClickListener { appendToExpression("2") }
        binding.btn3.setOnClickListener { appendToExpression("3") }
        binding.btn4.setOnClickListener { appendToExpression("4") }
        binding.btn5.setOnClickListener { appendToExpression("5") }
        binding.btn6.setOnClickListener { appendToExpression("6") }
        binding.btn7.setOnClickListener { appendToExpression("7") }
        binding.btn8.setOnClickListener { appendToExpression("8") }
        binding.btn9.setOnClickListener { appendToExpression("9") }
        binding.btnPlus.setOnClickListener { appendToExpression("+") }
        binding.btnMinus.setOnClickListener { appendToExpression("-") }
        binding.btnMul.setOnClickListener { appendToExpression("*") }
        binding.btnDiv.setOnClickListener { appendToExpression("/") }
        binding.btnEquals.setOnClickListener { calculateResult() }
        binding.btnClear.setOnClickListener { clearExpression() }
    }

    private fun appendToExpression(value: String) {
        binding.tvDisplay.text = binding.tvDisplay.text.toString() + value
    }

    private fun calculateResult() {
        viewModel.calculate(binding.tvDisplay.text.toString())
    }

    private fun clearExpression() {
        binding.tvDisplay.text = "0"
    }
}
