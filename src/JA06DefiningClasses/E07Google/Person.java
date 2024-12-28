package JA06DefiningClasses.E07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private final List<Pokemon> pokemons;
    private final List<Parent> parents;
    private final List<Child> children;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    @Override
    public String toString() {

        StringBuilder stringbuilder = new StringBuilder();

        stringbuilder.append(name).append("\n");

        stringbuilder.append("Company:\n");
        if (company != null) {
            stringbuilder.append(company).append("\n");
        }

        stringbuilder.append("Car:\n");
        if (car != null) {
            stringbuilder.append(car).append("\n");
        }

        stringbuilder.append("Pokemon:\n");
        for (Pokemon pokemon : pokemons) {
            stringbuilder.append(pokemon).append("\n");
        }

        stringbuilder.append("Parents:\n");
        for (Parent parent : parents) {
            stringbuilder.append(parent).append("\n");
        }

        stringbuilder.append("Children:\n");
        for (Child child : children) {
            stringbuilder.append(child).append("\n");
        }

        return stringbuilder.toString();
    }
}