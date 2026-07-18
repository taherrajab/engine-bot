package com.example.calculator

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDisplay.text = viewModel.displayString.value
        viewModel.displayString.observe(this) { value ->
            binding.tvDisplay.text = value
        }
        setupNumberButtons()
        setupOperatorButtons()
    }

    private fun setupNumberButtons() {
        binding.btn0.setOnClickListener { viewModel.onNumberClicked("0") }
        binding.btn1.setOnClickListener { viewModel.onNumberClicked("1") }
        binding.btn2.setOnClickListener { viewModel.onNumberClicked("2") }
        binding.btn3.setOnClickListener { viewModel.onNumberClicked("3") }
        binding.btn4.setOnClickListener { viewModel.onNumberClicked("4") }
        binding.btn5.setOnClickListener { viewModel.onNumberClicked("5") }
        binding.btn6.setOnClickListener { viewModel.onNumberClicked("6") }
        binding.btn7.setOnClickListener { viewModel.onNumberClicked("7") }
        binding.btn8.setOnClickListener { viewModel.onNumberClicked("8") }
        binding.btn9.setOnClickListener { viewModel.onNumberClicked("9") }
        binding.btnDot.setOnClickListener { viewModel.onNumberClicked(".") }
    }

    private fun setupOperatorButtons() {
        binding.btnPlus.setOnClickListener { viewModel.onOperatorClicked("+") }
        binding.btnMinus.setOnClickListener { viewModel.onOperatorClicked("-") }
        binding.btnMul.setOnClickListener { viewModel.onOperatorClicked("*") }
        binding.btnDiv.setOnClickListener { viewModel.onOperatorClicked("/") }
        binding.btnEquals.setOnClickListener { viewModel.onEqualsClicked() }
    }
}
