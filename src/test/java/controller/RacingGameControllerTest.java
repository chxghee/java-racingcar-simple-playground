package controller;

import model.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    RacingGameController controller;
    private List<String> carNames;
    private int tryCount;

    @BeforeEach
    void setUp() {
        carNames = List.of("car1", "car2", "car3");
        tryCount = 5;
    }

    @Test
    void 입력횟수만큼_라운드가_진행되어야_한다() {
        controller = new RacingGameController(carNames, tryCount, new MoveNumberGenerator());
        controller.run();

        assertThat(controller.getWinners().getWinnersPosition()).isEqualTo(5);
    }

    private static class MoveNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 5;
        }
    }
}
