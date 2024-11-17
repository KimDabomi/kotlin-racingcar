package racingcar.controller

import racingcar.service.RacingCarService

class RacingCarController(private val racingCarService: RacingCarService) {
    fun start() {
        val racingCars = racingCarService.getRacingCars()
        val tryCount = racingCarService.startTryCount()
        val raceMap = racingCarService.startRace(racingCars, tryCount)
        racingCarService.startWinner(raceMap)
    }
}
