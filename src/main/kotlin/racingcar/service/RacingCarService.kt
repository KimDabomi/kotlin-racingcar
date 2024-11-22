package racingcar.service

import racingcar.dto.RacingCarDto
import racingcar.model.Forward
import racingcar.model.RacingCar
import racingcar.model.TryCount
import racingcar.model.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

private const val DELIMITER = ","

class RacingCarService(
    private val tryCount: TryCount,
    private val forward: Forward,
) {
    fun readRacingCarNames(): List<String> {
        InputView.readNumberCars()
        val userInput: String = readln()
        return userInput.split(DELIMITER).map { it.trim() }.filter { it.isNotEmpty() }
    }

    fun readTryCount(): Int {
        InputView.readTryCount()
        val userInput: Int = readln().toInt()
        return tryCount.getTryCount(userInput)
    }

    fun runRace(
        carNames: List<String>,
        tryCount: Int,
    ): List<RacingCar> {
        ResultView.showRacingStart()

        val raceCars = carNames.map { RacingCar.from(it) }

        for (i in 0 until tryCount) {
            raceCars.forEach { car ->
                car.race { forward.pickRandomNumberInRange() >= 4 }
            }
            ResultView.showRacingResult(raceCars.map { RacingCarDto(it.carName, it.position) })
        }

        return raceCars
    }

    fun determineAndShowWinners(raceCars: List<RacingCar>) {
        val winners: List<String> = Winner.determineWinners(raceCars)
        ResultView.showWinner(winners)
    }
}
