package JA06DefiningClasses.E06PokemonTrainer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command1;
        while (!"Tournament".equals(command1 = scanner.nextLine())) {

            String[] tokens = command1.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);








        }



    }
}
