import controller.InputHandler;
import controller.RacingGameController;
import model.RacingNumberGenerator;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<String> carNames = inputHandler.getCarNames();
        int tryCount = inputHandler.getTryCount();

        RacingGameController racingGameController = new RacingGameController(carNames, tryCount, new RacingNumberGenerator());
        racingGameController.run();

        OutputView.printWinners(racingGameController.getWinners().getWinnersToString());
    }
}
