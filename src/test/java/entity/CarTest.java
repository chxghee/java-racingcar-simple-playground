package entity;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 숫자가_3이하면_위치를_유지한다 () {
        Car car = new Car("car1");
        car.moveCar(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_한_칸_이동한다 () {
        Car car = new Car("car1");
        car.moveCar(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차의_위치가_우승_위치와_같으면_우승자이다() {
        int winningPosition = 1;
        Car car = new Car("car1");
        car.moveCar(4);

        Assertions.assertThat(car.isWinner(winningPosition)).isTrue();
    }
}