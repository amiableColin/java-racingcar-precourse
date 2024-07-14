package racingcar;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WinnerFinder {
    private final Car[] cars;

    public WinnerFinder(Car[] cars) {
        this.cars = cars;
    }

    public String findWinner() {
        return Arrays.stream(this.cars)
                .filter(car -> car.getLine().length() == maxCount())
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private int maxCount() {
        return Arrays.stream(this.cars)
                .mapToInt(car -> car.getLine().length())
                .max().orElse(0);
    }
}
