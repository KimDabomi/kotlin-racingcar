package racingcar.model

import racingcar.model.exception.RacingCarException

private const val SPLIT_UNIT = ","

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
        fun getCarNames(userCarName: String): List<String> {
            val carNameList: MutableList<String> = ArrayList()
            val carNames = splitCarName(userCarName)
            for (carName in carNames) {
                RacingCarException.checkCarNameTypeAndSize(carName)
                carNameList.add(carName.trim { it <= ' ' })
            }
            return carNameList
        }

        private fun splitCarName(userCarName: String): Array<String> {
            return userCarName.split(SPLIT_UNIT.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }
    }
}
