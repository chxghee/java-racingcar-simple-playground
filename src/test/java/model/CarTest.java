package model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 숫자가_3이하면_위치를_유지한다 () {
        Car car = new Car("car1");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_한_칸_이동한다 () {
        Car car = new Car("car1");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 주어진_위치와_자동차의_형재_위치가_일치하면_참이다() {
        int position = 2;

        Car car = new Car("car1");
        car.move(4);
        car.move(4);

        assertThat(car.hasSamePosition(position)).isTrue();
    }

    @Test
    void 자동차_현재_위치만큼_DASH를_출력한다() {
        int moveCount = 5;
        Car car = new Car("car1");
        for (int i = 0; i < moveCount; i++) {
            car.move(5);
        }

        String newPositionMessage = car.getCarPositionToString();
        long result = newPositionMessage.chars().filter(ch -> ch == '-').count();
        assertThat(result).isEqualTo(moveCount);
    }
}
