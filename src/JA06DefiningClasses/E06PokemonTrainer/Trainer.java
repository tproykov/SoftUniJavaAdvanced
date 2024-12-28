package JA06DefiningClasses.E06PokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemons;

    public Trainer(String name, int numberOfBadges, List<Pokemon> collectionOfPokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.collectionOfPokemons = collectionOfPokemons;
    }
}
