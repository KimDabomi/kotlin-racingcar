package racingcar.model.exception

class RacingCarException(errorMessage: String?) : IllegalArgumentException(errorMessage) {
    companion object {
        private const val TYPE_AND_SIZE = "^[a-z]{1,5}$"
        private const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하의 소문자만 가능합니다."

        fun checkCarNameTypeAndSize(userCarName: String) {
            if (!userCarName.matches(TYPE_AND_SIZE.toRegex())) {
                throw RacingCarException(CAR_NAME_ERROR_MESSAGE)
            }
        }
    }
}
