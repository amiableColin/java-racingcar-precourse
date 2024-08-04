package racingcar;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Application {
    public static Car[] promptCarName(Scanner s) {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] car_names = s.next().split(",");
            try {
                Car[] cars = Arrays.stream(car_names).map(Car::new).toArray(Car[]::new);
                return cars;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int promptTrialCount(Scanner s) {
        while (true) {
            System.out.println("시도할 횟수는 몇회인가요?");
            String T = s.next();
            try {
                boolean isNumeric = T.chars().allMatch(Character::isDigit);
                if (!isNumeric)
                    throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
                return Integer.parseInt(T);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printRace(Car[] cars, int T) {
        PlayingRace play = new PlayingRace(cars);
        for (int i = 0; i < T; i++) {
            play.raceStart();
            String raceString = Arrays.stream(cars).map(car -> car.getName() + " : " + car.getLine()).collect(Collectors.joining("\n"));
            System.out.println(raceString);
            System.out.println();
        }
    }

    public static void printWinner(Car[] cars) {
        System.out.println("실행 결과");
        WinnerFinder winner = new WinnerFinder(cars);
        System.out.print("최종 우승자 : " + winner.findWinner());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Car[] cars = promptCarName(s);
        int T = promptTrialCount(s);
        s.close();

        printRace(cars, T);
        printWinner(cars);
    }
}
