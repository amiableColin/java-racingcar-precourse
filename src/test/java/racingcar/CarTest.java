package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @DisplayName("Car Test")
    @Test
    void startCarTest() {
        Car car = new Car("A");
        assertThat(car.getName()).isEqualTo("A");
    }

    @DisplayName("Move Test")
    @Test
    void startMoveTest() {
        Car car = new Car("B");

        car.moveIfPossible(5);

        assertThat(car.getLine()).isEqualTo("--");
    }
}