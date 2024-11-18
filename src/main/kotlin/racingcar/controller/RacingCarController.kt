package racingcar.controller

import racingcar.service.RacingCarService

class RacingCarController(private val racingCarService: RacingCarService) {
    fun start() {
        val racingCars = racingCarService.readRacingCarNames()
        val tryCount = racingCarService.readTryCount()
        val raceMap = racingCarService.runRace(racingCars, tryCount)
        racingCarService.determineAndShowWinners(raceMap)
    }
}
