package JA06DefiningClasses.E06PokemonTrainer;

import java.util.List;
import java.util.ArrayList;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemons() {
        return collectionOfPokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        collectionOfPokemons.add(pokemon);
    }

    public void increaseBadges() {
        numberOfBadges++;
    }

    public boolean hasElementType(String element) {
        return collectionOfPokemons.stream()
                .anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    public void reduceHealth() {
        collectionOfPokemons.forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
        collectionOfPokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }
}
