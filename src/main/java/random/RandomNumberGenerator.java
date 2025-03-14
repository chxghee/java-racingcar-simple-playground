package random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public int generate() {
        return ThreadLocalRandom.current().nextInt(RANDOM_NUMBER_BOUND);
    }
}
