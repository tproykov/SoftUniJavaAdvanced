package JA06DefiningClasses.E05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;
            if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];

                engine = new Engine(model, power, displacement, efficiency);
                engines.add(engine);
            }
            else if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);

                    engine = new Engine(model, power, displacement);
                    engines.add(engine);
                }
                else {
                    String efficiency = tokens[2];

                    engine = new Engine(model, power, efficiency);
                    engines.add(engine);
                }
            }
            else {
                engine = new Engine(model, power);
                engines.add(engine);
            }
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {






            
        }




    }

}
