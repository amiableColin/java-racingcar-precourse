package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WinnerFinderTest {
    @DisplayName("WinnerFinder Test")
    @Test
    void startCarTest() {
        Car[] cars = new Car[3];
        for (int i = 0; i < 3; i++) {
            cars[i] = new Car(Integer.toString(i+1));
        }

        cars[0].moveIfPossible(5);
        cars[0].moveIfPossible(5);

        cars[1].moveIfPossible(5);


        WinnerFinder finder = new WinnerFinder(cars);

        assertThat(finder.findWinner()).isEqualTo("1");
    }
}