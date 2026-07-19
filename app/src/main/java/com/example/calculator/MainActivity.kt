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

        viewModel.display.observe(this) { value ->
            binding.tvDisplay.text = value
        }

        setupListeners()
    }

    private fun setupListeners() {
        binding.apply {
            btn0.setOnClickListener { viewModel.onNumberClick(''0'') }
            btn1.setOnClickListener { viewModel.onNumberClick(''1'') }
            btn2.setOnClickListener { viewModel.onNumberClick(''2'') }
            btn3.setOnClickListener { viewModel.onNumberClick(''3'') }
            btn4.setOnClickListener { viewModel.onNumberClick(''4'') }
            btn5.setOnClickListener { viewModel.onNumberClick(''5'') }
            btn6.setOnClickListener { viewModel.onNumberClick(''6'') }
            btn7.setOnClickListener { viewModel.onNumberClick(''7'') }
            btn8.setOnClickListener { viewModel.onNumberClick(''8'') }
            btn9.setOnClickListener { viewModel.onNumberClick(''9'') }
            btnPlus.setOnClickListener { viewModel.onOperatorClick(''+'') }
            btnMinus.setOnClickListener { viewModel.onOperatorClick(''-'') }
            btnMul.setOnClickListener { viewModel.onOperatorClick(''*'') }
            btnDiv.setOnClickListener { viewModel.onOperatorClick(''/'') }
            btnEquals.setOnClickListener { viewModel.onEqualsClick() }
            btnClear.setOnClickListener { viewModel.clear() }
        }
    }
}