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
    fun getRacingCars(): List<String> {
        InputView.readNumberCars()
        val userInput: String = readln()
        return RacingCar.getCarNames(userInput)
    }

    fun startTryCount(): Int {
        InputView.readTryCount()
        val userInput: Int = readln().toInt()
        return tryCount.getTryCount(userInput)
    }

    fun startRace(
        carNames: List<String>,
        tryCount: Int,
    ): List<RacingCar> {
        ResultView.showRacingStart()

        val raceMap = carNames.map { RacingCar(it) }

        for (i in 0 until tryCount) {
            raceMap.forEach { car ->
                car.race { forward.pickRandomNumberInRange() >= 4 }
            }
            ResultView.showRacingResult(raceMap)
        }

        return raceMap
    }

    fun startWinner(raceMap: List<RacingCar>) {
        val winners: List<String> = Winner.determineWinners(raceMap)
        ResultView.showWinner(winners)
    }
}
