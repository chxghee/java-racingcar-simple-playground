package domain;

import random.NumberGenerator;
import random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
    }

    public void round() {
        for (Car car : cars) {
            car.moveCar(numberGenerator.generate());
        }
    }

    public void determineWinners() {
        int winningPosition = findWinningPosition();
        winners = cars.stream()
                .filter(car -> car.hasSamePosition(winningPosition))
                .toList();
    }

    public int findWinningPosition() {
        return cars.stream().mapToInt(car -> car.getPosition()).max().orElse(0);
    }
}
