package controller;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameControllerTest {

    private List<String> carNames;
    private int tryCount;

    @BeforeEach
    void setUp() {
        carNames = List.of("car1", "car2", "car3");
        tryCount = 5;
    }

    @Test
    void 입력횟수만큼_라운드가_진행되어야_한다() {
        RacingGameController controller = new RacingGameController(carNames, tryCount, new MoveNumberGenerator());
        controller.run();

        assertThat(controller.getWinners().getWinnersPosition()).isEqualTo(5);
    }

    @Test
    void 우승자가_한_명_이상_존재할_수_있다() {
        RacingGameController controller = new RacingGameController(carNames, tryCount, new MoveNumberGenerator());
        controller.run();
        Winners winners = controller.getWinners();
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 우승자가_정해지지_않은_상태에서_우승자를_조회하면_예외가_발생한다() {
        RacingGameController controller = new RacingGameController(carNames, tryCount, new MoveNumberGenerator());

        assertThatThrownBy(() -> controller.getWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("레이싱 게임이 아직 시작되지 않았습니다!");
    }

    @Test
    void 레이싱_동안_아무도_전진하지_못하면_위치가_0으로_공동우승한다() {
        RacingGameController controller = new RacingGameController(carNames, tryCount, new InplaceNumberGenerator());
        controller.run();
        Winners winners = controller.getWinners();

        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners.getWinnersPosition()).isEqualTo(0);
    }
}
