package controller;

import model.Cars;
import model.NumberGenerator;
import model.Racing;
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
        Racing racing = startGame(cars, tryCount);
        finishGame(racing);
    }

    private Racing startGame(Cars cars, int tryCount) {
        OutputView.printGameStartMessage();
        Racing racing = new Racing(cars);
        for (int i = 0; i < tryCount; i++) {
            racing.round();
            OutputView.printRoundResult(cars.toString());
        }
        return racing;
    }

    private void finishGame(Racing racing) {
        racing.findWinners();
        winners = racing.getWinners();
    }

    public Winners getWinners() {
        if (winners == null) {
            throw new IllegalStateException("RacingGameController has not been run yet.");
        }
        return winners;
    }
}
