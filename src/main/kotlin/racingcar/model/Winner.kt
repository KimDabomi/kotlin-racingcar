package racingcar.model

object Winner {
    fun getWinners(raceCars: List<RacingCar>): List<String> {
        val maxDistance = raceCars.maxOf { it.position }
        return raceCars.filter { it.position == maxDistance }
            .map { it.carName }
    }
}
