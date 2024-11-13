import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FourBasicOperationsTest : StringSpec({
    val operations = FourBasicOperations()

    "사칙연산 테스트1" {
        operations.calculate("2 + 3 * 4 / 2 - 3") shouldBe 5
    }

    "사칙연산 테스트2" {
        operations.calculate("4 * 2 * 3 / 6 + 5 - 1") shouldBe 8
    }

    "연산 기호 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            operations.calculate("2 + 3 % 4")
        }
    }

    "빈 공백 문자 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            operations.calculate("2 + + 3")
        }
    }

    "null 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            operations.calculate(null.toString())
        }
    }

    "빈 문자 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            operations.calculate("")
        }
    }
})
