package JA12Exam_15_Feb_2025;

import java.util.Scanner;

public class E02Pacman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int gridSize = Integer.parseInt(scanner.nextLine());

        char[][] grid = new char[gridSize][gridSize];
        int pacmanRowPosition = 0;
        int pacmanColPosition = 0;

        for (int row = 0; row < gridSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < gridSize; col++) {
                grid[row][col] = line.charAt(col);
                if (grid[row][col] == 'P') {
                    pacmanRowPosition = row;
                    pacmanColPosition = col;
                    grid[row][col] = '-';
                }
            }
        }

        int stars = countTheStars(grid);
        int health = 100;
        boolean pacmanFrozen = false;
        String command;
        while (!"END".equals(command = scanner.nextLine())) {

            switch (command) {
                case "up" -> pacmanRowPosition--;
                case "down" -> pacmanRowPosition++;
                case "left" -> pacmanColPosition--;
                case "right" -> pacmanColPosition++;
            }

            if (isOutOfBounds(gridSize, pacmanRowPosition, pacmanColPosition)) {
                int[] pacmanCoordinates = teleport(gridSize, command, pacmanRowPosition, pacmanColPosition);
                pacmanRowPosition = pacmanCoordinates[0];
                pacmanColPosition = pacmanCoordinates[1];
            }

            if (grid[pacmanRowPosition][pacmanColPosition] == '*') {
                stars--;
                grid[pacmanRowPosition][pacmanColPosition] = '-';
                if (stars == 0) {
                    break;
                }
            }

            if (grid[pacmanRowPosition][pacmanColPosition] == 'G') {
                if (!pacmanFrozen) {
                    health -= 50;
                }
                else {
                    pacmanFrozen = false;
                }
                grid[pacmanRowPosition][pacmanColPosition] = '-';
                if (health <= 0) {
                    break;
                }
            }

            if (grid[pacmanRowPosition][pacmanColPosition] == 'F') {
                pacmanFrozen = true;
                grid[pacmanRowPosition][pacmanColPosition] = '-';
            }
        }

        grid[pacmanRowPosition][pacmanColPosition] = 'P';

        if (health <= 0) {
            System.out.println("Game over! Pacman last coordinates [" + pacmanRowPosition + ","
                    + pacmanColPosition + "]");
        }
        else if (stars == 0) {
            System.out.println("Pacman wins! All the stars are collected.");
        }
        else {
            System.out.println("Pacman failed to collect all the stars.");
        }

        System.out.println("Health: " + health);

        if (stars > 0) {
            System.out.println("Uncollected stars: " + stars);
        }

        printMatrix(grid);
    }

    private static int countTheStars(char[][] grid) {
        int stars = 0;
        for (char[] chars : grid) {
            for (int col = 0; col < grid.length; col++) {
                if (chars[col] == '*') {
                    stars++;
                }
            }
        }
        return stars;
    }

    private static boolean isOutOfBounds(int gridSize, int pacmanRowPosition, int pacmanColPosition) {
        return pacmanRowPosition >= gridSize || pacmanColPosition >= gridSize
                || pacmanRowPosition < 0 || pacmanColPosition < 0;
    }

    private static int[] teleport(int gridSize, String command, int pacmanRowPosition, int pacmanColPosition) {
        int[] pacmanCoordinates = new int[2];
        pacmanCoordinates[0] = pacmanRowPosition;
        pacmanCoordinates[1] = pacmanColPosition;
        switch (command) {
            case "up" -> pacmanCoordinates[0] = gridSize - 1;
            case "down" -> pacmanCoordinates[0] = 0;
            case "left" -> pacmanCoordinates[1] = gridSize - 1;
            case "right" -> pacmanCoordinates[1] = 0;
        }
        return pacmanCoordinates;
    }

    private static void printMatrix(char[][] grid) {
        for (char[] chars : grid) {
            for (int col = 0; col < grid.length; col++) {
                System.out.print(chars[col]);
            }
            System.out.println();
        }
    }
}