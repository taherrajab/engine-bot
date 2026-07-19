import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _display = MutableLiveData<String>()
    val display: LiveData<String> get() = _display

    private var operand1: Double? = null
    private var operand2: Double? = null
    private var operator: String? = null

    init {
        _display.value = ''0''
    }

    fun onNumberClick(number: String) {
        _display.value = display.value + number
    }

    fun onOperatorClick(op: String) {
        operator = op
        operand1 = display.value?.toDouble()
        _display.value = '' ''
    }

    fun onEqualsClick() {
        operand2 = display.value?.toDouble()
        val result = when (operator) {
            ''+'' -> operand1!! + operand2!!
            ''-'' -> operand1!! - operand2!!
            ''*'' -> operand1!! * operand2!!
            ''/'' -> operand1!! / operand2!!
            else -> 0
        }
        _display.value = result.toString()
    }
}