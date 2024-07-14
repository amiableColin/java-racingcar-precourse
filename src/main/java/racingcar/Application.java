package racingcar;

import java.util.Random;
import java.util.Scanner;

public class Application {

    // 0~9 사이의 정수를 뽑고, 뽑은 수가 4 이상일 때 전진.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] car_names;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            car_names = s.next().split(",");

            try {
                for (String car_name : car_names) {
                    if (car_name.length() > 5) {
                        throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
                    }
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }


        Car[] cars = new Car[car_names.length];
        for (int k = 0; k < cars.length; k++) {
            cars[k] = new Car(car_names[k]);
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int T = -1;
        try {
            T = s.nextInt();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }

        Random r = new Random();

        System.out.println("실행 결과");
        for (int i = 0; i < T; i++) {
            for (Car car:cars) {
                car.isMove(r.nextInt(10));
                System.out.println(car.getName() + " : " + car.getLine());
            }
            System.out.println();
        }
        int[] maxs = new int[cars.length];
        int max = 0;
        for (int i = 0; i < cars.length; i++) {
            maxs[i] = cars[i].getLine().length();
            if (max < maxs[i]) {
                max = maxs[i];
            }
        }
        System.out.print("최종 우승자 : ");
        String winner = "";
        for (int i = 0; i < maxs.length; i++) {
            if (max == maxs[i]) {
                winner += cars[i].getName();
                winner += ", ";
            }
        }
        winner = winner.substring(0, winner.length() - 2);
        System.out.println(winner);
        s.close();
    }
}
