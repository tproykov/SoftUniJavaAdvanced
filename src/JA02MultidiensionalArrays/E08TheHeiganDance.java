package JA02MultidiensionalArrays;

import java.util.Scanner;

public class E08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int[] playerPosition = {8, 8};
        int[][] matrix = new int[15][15];
        int playerStartingPoints = 18500;
        int heiganStartingPoints = 3000000;

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
