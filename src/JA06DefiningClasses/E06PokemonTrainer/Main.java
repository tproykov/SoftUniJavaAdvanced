package JA06DefiningClasses.E06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String command1;
        while (!"Tournament".equals(command1 = scanner.nextLine())) {
            String[] tokens = command1.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(pokemon);
        }

        String command2;
        while (!"End".equals(command2 = scanner.nextLine())) {
            String element = command2;

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(element)) {
                    trainer.increaseBadges();
                } else {
                    trainer.reduceHealth();
                }
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .forEach(trainer -> System.out.printf("%s %d %d%n",
                        trainer.getName(),
                        trainer.getNumberOfBadges(),
                        trainer.getCollectionOfPokemons().size()));
    }
}