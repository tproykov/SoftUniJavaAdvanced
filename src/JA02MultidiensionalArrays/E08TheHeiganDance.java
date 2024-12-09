package JA02MultidiensionalArrays;

import java.util.Scanner;

public class E08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int[] playerPosition = {8, 8};
        int[][] matrix = new int[15][15];
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        String winner = "";

        String command = scanner.nextLine();
        while (true) {

            heiganPoints -= damageToHeigan;
            if (heiganPoints <= 0) {
                winner = "player";
                break;
            }

            String[] tokens = command.split("\\s+");
            String spellType = tokens[0];
            int rowHit = Integer.parseInt(tokens[1]);
            int colHit = Integer.parseInt(tokens[2]);

            switch (spellType) {

                case "Cloud" -> {

                    for (int row = rowHit - 1; row >= rowHit + 1; row++) {
                        for (int col = colHit - 1; col >= colHit + 1; col--) {




                            
                        }



                    }




                }

                case "Eruption" -> {}
            }







            command = scanner.nextLine();
        }



    }

}
