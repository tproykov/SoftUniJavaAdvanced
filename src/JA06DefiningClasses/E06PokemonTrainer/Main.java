package JA06DefiningClasses.E06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();
        List<Pokemon> pokemons = new ArrayList<>();

        String command1;
        while (!"Tournament".equals(command1 = scanner.nextLine())) {

            String[] tokens = command1.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemons.add(pokemon);










        }



    }
}
