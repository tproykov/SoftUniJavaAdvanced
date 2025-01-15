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

        while (playerPoints > 0 && heiganPoints > 0) {
            heiganPoints -= damageToHeigan;

            // Handle active cloud damage first
            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;  // Reset cloud after damage is applied
                if (playerPoints <= 0) {
                    printGameResult(heiganPoints, playerPoints, "Plague Cloud", playerPosition);
                    return;
                }
            }

            // If Heigan is dead, end the game without applying new spell
            if (heiganPoints <= 0) {
                printGameResult(heiganPoints, playerPoints, lastSpell, playerPosition);
                return;
            }

            // Get next spell
            String command;
            if (scanner.hasNextLine()) {
                command = scanner.nextLine();
            } else {
                break;
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
                    } else {
                        playerPoints -= 6000;
                    }

                    if (playerPoints <= 0) {
                        printGameResult(heiganPoints, playerPoints, spellType, playerPosition);
                        return;
                    }
                }
            }
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
        // Try moving in order: up, right, down, left
        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] move : moves) {
            int newRow = playerPosition[0] + move[0];
            int newCol = playerPosition[1] + move[1];

            if (canMoveTo(newRow, newCol, hitRow, hitCol)) {
                playerPosition[0] = newRow;
                playerPosition[1] = newCol;
                return true;
            }
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
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        if (playerPoints <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerPoints);
        }

        System.out.println("Final position: " + position[0] + ", " + position[1]);
    }
}