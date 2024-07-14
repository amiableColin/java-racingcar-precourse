package racingcar;

public class WinnerFinder {
    private Car[] cars;

    public WinnerFinder(Car[] cars) {
        this.cars = cars;
    }

    public String findWinner() {
        int max = maxCount();
        String winner = "";
        for (int i = 0; i < this.cars.length; i++) {
            if (max == this.cars[i].getLine().length()) {
                winner += cars[i].getName();
                winner += ", ";
            }
        }
        winner = winner.substring(0, winner.length() - 2);
        return winner;
    }

    private int maxCount() {
        int max = 0;
        for (int i = 0; i < this.cars.length; i++) {
            if (max < this.cars[i].getLine().length()) {
                max = this.cars[i].getLine().length();
            }
        }
        return max;
    }
}
