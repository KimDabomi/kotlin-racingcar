package racingcar.view

import racingcar.model.RacingCar

object ResultView {
    private const val SHOW_RACING_START_MESSAGE = "실행 결과"
    private const val FORWARD_STATUS = "-"

    fun showRacingStart() {
        println()
        println(SHOW_RACING_START_MESSAGE)
    }

    fun showRacingResult(racingCars: List<RacingCar>) {
        racingCars.forEach { car ->
            println("${car.carName}: ${FORWARD_STATUS.repeat(car.position)}")
        }
        println()
    }

    fun showWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
