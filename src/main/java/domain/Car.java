package domain;

public class Car {

    private static final int MOVING_THRESHOLD = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar(int random) {
        if (random >= MOVING_THRESHOLD) {
            this.position += 1;
        }
    }

    public boolean hasSamePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}
