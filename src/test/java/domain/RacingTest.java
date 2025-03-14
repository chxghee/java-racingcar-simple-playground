package domain;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import random.InPlaceNumberGenerator;
import random.MoveNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        int carNum = 5;
        racing = new Racing(new MoveNumberGenerator());
        racing.createCars(carNum);
    }

    @Test
    void 자동차는_입력한_개수만큼_리스트에_추가된다() {
        assertThat(racing.getCars().size()).isEqualTo(5);
    }

    @Test
    void 가장_멀리_이동한_자동차가_우승이다() {
        List<Car> cars = racing.getCars();
        cars.get(0).moveCar(5);
        assertThat(racing.findWinningPosition()).isEqualTo(1);
    }

    @Test
    void 우승자가_한_명_이상_존재할_수_있다() {
        int roundNum = 5;
        racing.startRacing(roundNum);
        racing.determineWinners();
        assertThat(racing.getWinners().size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void 모든_라운드_전진하면_우승위치는_라운드_횟수와_같다() {
        int roundNom = 5;
        racing.startRacing(roundNom);
        assertThat(racing.findWinningPosition()).isEqualTo(5);
    }

    @Test
    void 모든_자동차가_4보다_작은_값을_받으면_모든_자동차의_위치는_0이다() {
        Racing racing = new Racing(new InPlaceNumberGenerator());
        racing.createCars(5);
        racing.round();

        assertThat(allCarsAtSamePosition(racing.getCars())).isTrue();
        assertThat(racing.findWinningPosition()).isEqualTo(0);
    }

    public boolean allCarsAtSamePosition(List<Car> cars) {
        int position = cars.get(0).getPosition(); // 첫 번째 자동차의 위치
        return cars.stream().allMatch(car -> car.getPosition() == position);
    }
}
