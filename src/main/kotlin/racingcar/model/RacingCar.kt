package racingcar.model

private const val SPLIT_UNIT = ","
private const val TYPE_AND_SIZE = "^[a-z]{1,5}$"
private const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하의 소문자만 가능합니다."

class RacingCar(val carName: String) {
    var position: Int = 0

    fun race(forwardCondition: () -> Boolean) {
        if (forwardCondition()) {
            position += 1
        }
    }

    override fun toString(): String {
        return "$carName: ${"-".repeat(position)}"
    }

    companion object {
        fun getRacingCarNames(userCarName: String): List<String> {
            val carNameList: MutableList<String> = ArrayList()
            val carNames = splitCarName(userCarName)
            for (carName in carNames) {
                checkCarNameTypeAndSize(carName)
                carNameList.add(carName.trim { it <= ' ' })
            }
            return carNameList
        }

        private fun splitCarName(userCarName: String): Array<String> {
            return userCarName.split(SPLIT_UNIT.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }

        private fun checkCarNameTypeAndSize(userCarName: String) {
            if (!userCarName.matches(TYPE_AND_SIZE.toRegex())) {
                throw IllegalArgumentException(CAR_NAME_ERROR_MESSAGE)
            }
        }
    }
}
