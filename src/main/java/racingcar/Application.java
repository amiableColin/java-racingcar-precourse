package racingcar;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static Car[] promptCarName(Scanner s) {
        Car[] cars;
        String[] car_names;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            car_names = s.next().split(",");
            cars = new Car[car_names.length];
            try {
                for (int i = 0; i < car_names.length; i++) {
                    cars[i] = new Car(car_names[i]);
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return cars;
    }

    public static int promptTrialCount(Scanner s) {
        while (true) {
            int T = -1;
            try {
                try {
                    System.out.println("시도할 횟수는 몇회인가요?");
                    T = s.nextInt();
                }
                catch (InputMismatchException e) {
                    s.next();
                    throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return T;
        }
    }

    public static void printRace(Car[] cars, int T) {
        PlayingRace play = new PlayingRace(cars);
        for (int i = 0; i < T; i++) {
            play.raceStart();
            for (Car car : cars) {
                System.out.println(car.getName() + " : " + car.getLine());
            }
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
