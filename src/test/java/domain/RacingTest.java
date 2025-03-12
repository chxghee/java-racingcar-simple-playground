package domain;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        int carNum = 5;
        racing = new Racing();
        racing.createCars(carNum);
    }

    @Test
    void 자동차는_입력한_개수만큼_리스트에_추가된() {
        Assertions.assertThat(racing.getCars().size()).isEqualTo(5);
    }

    @Test
    void 가장_먼_위치의_있는_자동차의_위치가_우승_위치이다() {
        List<Car> cars = racing.getCars();
        int i = 0;
        for (Car car : cars) {
            car.moveCar(i++);
        }
        Assertions.assertThat(racing.findWinningPosition()).isEqualTo(1);
    }

    @Test
    void 우승자가_한_명_이상_존재할_수_있다() {

        List<Car> cars = racing.getCars();
        for (Car car : cars) {
            car.moveCar(4);
        }

        Assertions.assertThat(racing.findWinner().size()).isGreaterThanOrEqualTo(1);
    }
}