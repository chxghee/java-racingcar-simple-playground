package controller;

import model.Cars;
import model.NumberGenerator;
import model.Winners;
import view.OutputView;

import java.util.List;

public class RacingGameController {

    private final List<String> inputCarNames;
    private final int tryCount;
    private final NumberGenerator numberGenerator;
    private Winners winners;

    public RacingGameController(List<String> inputCarNames, int inputTryCount, NumberGenerator numberGenerator) {
        this.inputCarNames = inputCarNames;
        this.tryCount = inputTryCount;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = Cars.create(inputCarNames, numberGenerator);
        startGame(cars, tryCount);
        finishGame(cars);
    }

    private void startGame(Cars cars, int tryCount) {
        OutputView.printGameStartMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            OutputView.printRoundResult(cars.getCarsPositionToString());
        }
    }

    private void finishGame(Cars cars) {
        Cars leadingCars = cars.getLeadingCars();
        winners = Winners.create(leadingCars.getCars());
    }

    public Winners getWinners() {
        if (winners == null) {
            throw new IllegalStateException("레이싱 게임이 아직 시작되지 않았습니다!");
        }
        return winners;
    }
}
