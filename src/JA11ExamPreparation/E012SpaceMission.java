package JA11ExamPreparation;

import java.util.Scanner;

public class E012SpaceMission {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int gridDimensions = Integer.parseInt(scanner.nextLine());

        char[][] grid = new char[gridDimensions][gridDimensions];
        int spaceshipRowPosition = 0;
        int spaceshipColumnPosition = 0;

        for (int row = 0; row < gridDimensions; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < gridDimensions; col++) {
                grid[row][col] = line[col].charAt(0);
                if (grid[row][col] == 'S') {
                    spaceshipRowPosition = row;
                    spaceshipColumnPosition = col;
                }
            }
        }

        int resources = 100;
        boolean firstMove = true;
        boolean lostInSpace = false;
        boolean strandedInSpace = false;
        boolean reachedDestination = false;
        while (true) {

            String command = scanner.nextLine();

            if (firstMove) {
                grid[spaceshipRowPosition][spaceshipColumnPosition] = '.';
                firstMove = false;
            }

            int spaceshipPreviousRowPosition = spaceshipRowPosition;
            int spaceshipPreviousColumnPosition = spaceshipColumnPosition;

            switch (command) {
                case "up" -> spaceshipRowPosition--;
                case "down" -> spaceshipRowPosition++;
                case "left" -> spaceshipColumnPosition--;
                case "right" -> spaceshipColumnPosition++;
            }

            resources -= 5;

            if (resources < 5 && grid[spaceshipRowPosition][spaceshipColumnPosition] != 'R') {
                strandedInSpace = true;
                grid[spaceshipRowPosition][spaceshipColumnPosition] = 'S';
                break;
            }

            if (isOutOfGrid(gridDimensions, spaceshipRowPosition, spaceshipColumnPosition)) {
                lostInSpace = true;
                grid[spaceshipPreviousRowPosition][spaceshipPreviousColumnPosition] = 'S';
                break;
            }

            if (grid[spaceshipRowPosition][spaceshipColumnPosition] == 'R') {
                resources += 10;
                if (resources > 100) {
                    resources = 100;
                }
            }

            if (grid[spaceshipRowPosition][spaceshipColumnPosition] == 'M') {
                resources -= 5;
                grid[spaceshipRowPosition][spaceshipColumnPosition] = '.';
            }

            if (grid[spaceshipRowPosition][spaceshipColumnPosition] == 'P') {
                reachedDestination = true;
                break;
            }
        }

        if (reachedDestination) {
            System.out.println("Mission accomplished! The spaceship reached Planet B with " + resources
                    + " resources left");
        }
        else if (strandedInSpace) {
            System.out.println("Mission failed! The spaceship was stranded in space.");
        }
        else if (lostInSpace) {
            System.out.println("Mission failed! The spaceship was lost in space.");
        }

        printGrid(grid);
    }

    private static boolean isOutOfGrid(int gridDimensions, int rowPosition, int colPosition) {
        if (rowPosition < 0 || rowPosition >= gridDimensions || colPosition < 0 || colPosition >= gridDimensions) {
            return true;
        }
        return false;
    }

    private static void printGrid(char[][] grid) {
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
