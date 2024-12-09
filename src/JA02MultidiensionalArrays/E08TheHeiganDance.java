package JA02MultidiensionalArrays;

import java.util.Scanner;

public class E08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());

        String command = scanner.nextLine();
        while (true) {

            String[] tokens = command.split("\\s+");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);





            command = scanner.nextLine();
        }



    }

}
