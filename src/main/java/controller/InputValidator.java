package controller;

import java.util.List;

public class InputValidator {

    private static final String CAR_NAMES_PATTERN = "^([a-zA-Z가-힣]+)(,[a-zA-Z가-힣]+)*$";
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final String CAR_NAMES_INPUT_ERROR_MESSAGE = "자동차 이름은 알파벳, 혹은 한글로 이루어지고 쉼표(,)를 기준으로 구분합니다!";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하입니다!";
    private static final String TRY_COUNT_INPUT_ERROR_MESSAGE = "시도 횟수는 1이상의 양수입니다!";


    public static void validateCarNames(String carNames) {
        if (!carNames.matches(CAR_NAMES_PATTERN)) {
            throw new IllegalArgumentException(CAR_NAMES_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateCarNameLength(List<String> carNames) {
        boolean result = carNames.stream()
                .anyMatch(carName -> carName.length() > MAXIMUM_CAR_NAME_LENGTH || carName.isEmpty());
        if (result) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_INPUT_ERROR_MESSAGE);
        }
    }
}
