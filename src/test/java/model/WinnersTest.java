package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnersTest {

    Winners winners;

    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car("car" + i));
        }
        winners = Winners.create(cars);
    }

    @Test
    void getWinners를_통해_얻은_객체를_변경하면_예외가_발생해야_한다() {
        List<Car> findWinners = winners.getWinners();

        assertThatThrownBy(() -> findWinners.add(new Car("KIA")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void size는_우승자의_크기를_반환해야_한다() {
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 우승자_이름_출력시_쉼표로_구분되어야_한다() {
        assertThat(winners.toString()).isEqualTo("car0, car1, car2");
    }
}
