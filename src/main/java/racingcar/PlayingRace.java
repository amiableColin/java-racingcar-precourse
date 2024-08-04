package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayingRace {
    private final Car[] cars;
    public PlayingRace(Car[] cars) {
        this.cars = cars;
    }
    public void raceStart() {
        for (Car car : cars) {
            car.moveIfPossible(Randoms.pickNumberInRange(0, 9));
        }
    }
}
