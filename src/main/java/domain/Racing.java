package domain;

import random.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public Racing(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        if (winners.isEmpty()) {
            throw new IllegalStateException("아직 우승자가 결정되지 않았습니다!");
        }
        return winners;
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
        determineWinners();
    }

    public void round() {
        for (Car car : cars) {
            car.moveCar(numberGenerator.generate());
        }
    }

    private void determineWinners() {
        int winningPosition = findWinningPosition();
        winners = cars.stream()
                .filter(car -> car.hasSamePosition(winningPosition))
                .toList();
    }

    public int findWinningPosition() {
        return cars.stream().mapToInt(car -> car.getPosition()).max().orElse(0);
    }
}
