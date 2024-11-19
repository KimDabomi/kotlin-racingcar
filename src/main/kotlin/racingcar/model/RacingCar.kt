package racingcar.model

class RacingCar(val carName: String, var position: Int = 0) {
    init {
        require(carName.matches(TYPE_AND_SIZE.toRegex())) { CAR_NAME_ERROR_MESSAGE }
    }

    fun race(forwardCondition: () -> Boolean) {
        if (forwardCondition()) {
            position += 1
        }
    }

    override fun toString(): String {
        return "$carName: ${"-".repeat(position)}"
    }

    companion object {
        private const val SPLIT_UNIT = ","
        private const val TYPE_AND_SIZE = "^[a-z]{1,5}$"
        private const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하의 소문자만 가능합니다."

        fun getRacingCarNames(carName: String): List<String> {
            return splitCarName(carName).map { it.trim() }
        }

        private fun splitCarName(carName: String): List<String> {
            return carName.split(SPLIT_UNIT).filter { it.isNotEmpty() }
        }
    }
}
