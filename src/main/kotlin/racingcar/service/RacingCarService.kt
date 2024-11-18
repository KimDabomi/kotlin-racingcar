package racingcar.service

import racingcar.model.Forward
import racingcar.model.RacingCar
import racingcar.model.TryCount
import racingcar.model.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarService(
    private val tryCount: TryCount,
    private val forward: Forward,
) {
    fun readRacingCarNames(): List<String> {
        InputView.readNumberCars()
        val userInput: String = readln()
        return RacingCar.getRacingCarNames(userInput)
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

        val raceCars = carNames.map { RacingCar(it) }

        for (i in 0 until tryCount) {
            raceCars.forEach { car ->
                car.race { forward.pickRandomNumberInRange() >= 4 }
            }
            ResultView.showRacingResult(raceCars)
        }

        return raceCars
    }

    fun determineAndShowWinners(raceCars: List<RacingCar>) {
        val winners: List<String> = Winner.determineWinners(raceCars)
        ResultView.showWinner(winners)
    }
}
