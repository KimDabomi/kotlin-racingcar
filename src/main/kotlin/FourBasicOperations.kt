class FourBasicOperations {
    fun calculate(expression: String): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }

        val cleanedExpression = expression.replace(" ", "")
        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<Char>()
        var currentNumber = StringBuilder()

        for (char in cleanedExpression) {
            when {
                char.isDigit() -> currentNumber.append(char)
                char in listOf('+', '-', '*', '/') -> {
                    if (currentNumber.isEmpty()) {
                        throw IllegalArgumentException("입력값이 잘못되었습니다.")
                    }

                    numbers.add(currentNumber.toString().toInt())
                    currentNumber = StringBuilder()
                    operators.add(char)
                }
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }

        if (currentNumber.isNotEmpty()) {
            numbers.add(currentNumber.toString().toInt())
        } else if (operators.isNotEmpty()) {
            throw IllegalArgumentException("입력값이 잘못되었습니다.")
        }

        return evaluate(numbers, operators)
    }

    private fun evaluate(
        numbers: List<Int>,
        operators: List<Char>,
    ): Int {
        val values = numbers.toMutableList()
        val ops = operators.toMutableList()

        var i = 0
        while (i < ops.size) {
            if (ops[i] == '*' || ops[i] == '/') {
                val left = values[i]
                val right = values[i + 1]
                val result = if (ops[i] == '*') left * right else left / right
                values[i] = result
                values.removeAt(i + 1)
                ops.removeAt(i)
            } else {
                i++
            }
        }

        var total = values[0]
        for (j in 0 until ops.size) {
            total = if (ops[j] == '+') total + values[j + 1] else total - values[j + 1]
        }

        return total
    }
}
