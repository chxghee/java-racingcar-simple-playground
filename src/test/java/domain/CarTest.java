package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 숫자가_3이하면_위치를_유지한다 () {
        Car car = new Car("car1");
        car.moveCar(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_한_칸_이동한다 () {
        Car car = new Car("car1");
        car.moveCar(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
