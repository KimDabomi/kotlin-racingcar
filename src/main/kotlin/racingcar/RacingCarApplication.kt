package racingcar

import racingcar.controller.RacingCarController
import racingcar.model.Forward
import racingcar.model.TryCount
import racingcar.service.RacingCarService

object RacingCarApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val tryCount = TryCount()
        val forward = Forward()
        val racingCarService = RacingCarService(tryCount, forward)
        val racingCarController = RacingCarController(racingCarService)
        racingCarController.start()
    }
}
