package JA02MultidiensionalArrays;

import java.util.Scanner;

public class E08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int[] playerPosition = {7, 7}; // Starting at center (0-based index)
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        boolean activeCloud = false;
        String lastSpell = "";

        
        String command = scanner.nextLine();
        while (true) {

            heiganPoints -= damageToHeigan;
            if (heiganPoints <= 0) {
                printGameResult(heiganPoints, playerPoints, lastSpell, playerPosition);
                return;
            }

            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;
                if (playerPoints <= 0) {
                    printGameResult(heiganPoints, playerPoints, "Plague Cloud", playerPosition);
                    return;
                }
            }

            String[] tokens = command.split("\\s+");
            String spellType = tokens[0];
            int rowHit = Integer.parseInt(tokens[1]);
            int colHit = Integer.parseInt(tokens[2]);
            lastSpell = spellType;

            if (isInDamageZone(playerPosition[0], playerPosition[1], rowHit, colHit)) {
                boolean moved = tryToMove(playerPosition, rowHit, colHit);

                if (!moved) {
                    if (spellType.equals("Cloud")) {
                        playerPoints -= 3500;
                        activeCloud = true;
                        if (playerPoints <= 0) {
                            printGameResult(heiganPoints, playerPoints, "Plague Cloud", playerPosition);
                            return;
                        }
                    } else {
                        playerPoints -= 6000;
                        if (playerPoints <= 0) {
                            printGameResult(heiganPoints, playerPoints, spellType, playerPosition);
                            return;
                        }
                    }
                }
            }

            if (!scanner.hasNextLine()) {
                break;
            }
            command = scanner.nextLine();
        }

        printGameResult(heiganPoints, playerPoints, lastSpell, playerPosition);
    }

    private static boolean isInDamageZone(int playerRow, int playerCol, int hitRow, int hitCol) {
        return Math.abs(playerRow - hitRow) <= 1 && Math.abs(playerCol - hitCol) <= 1;
    }

    private static boolean isInside(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }

    private static boolean tryToMove(int[] playerPosition, int hitRow, int hitCol) {
        if (canMoveTo(playerPosition[0] - 1, playerPosition[1], hitRow, hitCol)) {
            playerPosition[0]--;
            return true;
        }
        if (canMoveTo(playerPosition[0], playerPosition[1] + 1, hitRow, hitCol)) {
            playerPosition[1]++;
            return true;
        }
        if (canMoveTo(playerPosition[0] + 1, playerPosition[1], hitRow, hitCol)) {
            playerPosition[0]++;
            return true;
        }
        if (canMoveTo(playerPosition[0], playerPosition[1] - 1, hitRow, hitCol)) {
            playerPosition[1]--;
            return true;
        }
        return false;
    }

    private static boolean canMoveTo(int newRow, int newCol, int hitRow, int hitCol) {
        return isInside(newRow, newCol) && !isInDamageZone(newRow, newCol, hitRow, hitCol);
    }

    private static void printGameResult(double heiganPoints, int playerPoints, String lastSpell, int[] position) {
        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganPoints);
        }

        if (playerPoints <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerPoints);
        }

        System.out.println("Final position: " + position[0] + ", " + position[1]);
    }
}