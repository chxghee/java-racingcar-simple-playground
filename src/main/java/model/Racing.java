package model;

public class Racing {

    private Cars cars;
    private Winners winners;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public void findWinners() {
        winners = Winners.create(cars.getLeadingCars().getCars());
    }

    public void round() {
        cars.moveAll();
    }

    public Cars getCars() {
        return cars;
    }

    public Winners getWinners() {
        if (winners == null){
            throw new IllegalStateException("아직 우승자가 정해지지 않았습니다!");
        }
        return winners;
    }
}
