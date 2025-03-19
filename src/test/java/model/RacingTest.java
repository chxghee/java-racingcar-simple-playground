package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("BMW");
        carNames.add("Audi");
        carNames.add("Ford");
    }

    @Test
    void n회_라운드를_진행하면_자동차들의_위치는_n이하이다() {
        int roundNumber = 10;
        Cars cars = Cars.create(carNames, new RacingNumberGenerator());
        Racing racing = new Racing(cars);

        for (int i = 0; i < roundNumber; i++) {
            racing.round();
        }
        boolean result = racing.getCars().getCars().stream()
                .allMatch(car -> car.getPosition() <= roundNumber);
        assertThat(result).isTrue();
    }

    @Test
    void 우승자가_한_명_이상_존재할_수_있다() {
        int roundNumber = 5;
        Cars cars = Cars.create(carNames, new MoveNumberGenerator());
        Racing racing = new Racing(cars);

        for (int i = 0; i < roundNumber; i++) {
            racing.round();
        }
        racing.findWinners();
        Winners winners = racing.getWinners();
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 우승자가_정해지지_않은_상태에서_우승자를_조회하면_예외가_발생한다() {
        Cars cars = Cars.create(carNames, new MoveNumberGenerator());
        Racing racing = new Racing(cars);

        assertThatThrownBy(() -> racing.getWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("아직 우승자가 정해지지 않았습니다!");
    }

    private static class MoveNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 5;
        }
    }
}
