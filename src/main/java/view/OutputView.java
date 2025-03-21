package view;

public class OutputView {

//    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
//    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
//    private static final String GAME_START_MESSAGE = "실행 결과";
//    private static final String WINNING_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printTryCountInputMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printGameStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(String roundResult) {
        System.out.println(roundResult);
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
