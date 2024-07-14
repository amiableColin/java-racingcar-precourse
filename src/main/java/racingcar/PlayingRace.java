package racingcar;
import java.util.Random;
public class PlayingRace {
    private final Car[] cars;
    public PlayingRace(Car[] cars) {
        this.cars = cars;
    }
    public void raceStart() {
        Random r = new Random();

        for (Car car : cars) {
            car.isMove(r.nextInt(10));
        }
    }
}
