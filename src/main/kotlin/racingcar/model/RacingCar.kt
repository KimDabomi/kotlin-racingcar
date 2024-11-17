package racingcar.model

private const val FORWARD_STATUS = "-"

class RacingCar(private val carNumber: Int) {
    var position: Int = 0
        private set

    fun race(forwardCondition: () -> Boolean) {
        if (forwardCondition()) {
            position += 1
        }
    }

    override fun toString(): String {
        return FORWARD_STATUS.repeat(position)
    }
}
