package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = new ArrayList<>(winners);
    }

    public static Winners create(List<Car> winners) {
        return new Winners(winners);
    }

    public int size() {
        return winners.size();
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    public int getWinnersPosition() {
        return winners.get(0).getPosition();
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
