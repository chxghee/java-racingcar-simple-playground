package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void createCars(int carNum) {
        for (int i = 0; i < carNum; i++) {
            this.cars.add(new Car("car" + i));
        }
    }

    public void startRacing(int roundNum) {
        for (int i = 0; i < roundNum; i++) {
            round();
        }
    }

    public void round() {
        for (Car car : cars) {
            Random random = new Random();
            int num = random.nextInt(10);
            car.moveCar(num);
        }
    }

    public List<Car> findWinner() {
        int winningPosition = findWinningPosition();
        return cars.stream()
                .filter(car -> car.isWinner(winningPosition))
                .toList();
    }

    public int findWinningPosition() {
        return cars.stream().mapToInt(car -> car.getPosition()).max().orElse(0);
    }
}
