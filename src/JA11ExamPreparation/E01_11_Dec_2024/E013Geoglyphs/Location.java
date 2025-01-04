package JA11ExamPreparation.E01_11_Dec_2024.E013Geoglyphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Location {
    private String name;
    private Collection<Geoglyph> geoglyphs;

    public Location(String name) {
        this.name = name;
        this.geoglyphs = new ArrayList<>();
    }

    public String addGeoglyph(Geoglyph geoglyph) {
        if (this.geoglyphs.stream().anyMatch(g -> g.getName().equals(geoglyph.getName()))) {
            throw new IllegalArgumentException("This geoglyph exists in the location!");
        }
        this.geoglyphs.add(geoglyph);
        return String.format("%s added to %s.", geoglyph.getName(), this.name);
    }

    public boolean removeGeoglyph(String name) {
        return this.geoglyphs.removeIf(g -> g.getName().equals(name));
    }

    public String getGeoglyphsByConstructionTechnique(String constructionTechnique) {
        Collection<String> matchingGeoglyphs = this.geoglyphs.stream()
                .filter(g -> g.getConstructionTechnique().equals(constructionTechnique))
                .map(Geoglyph::getName)
                .collect(Collectors.toList());

        if (matchingGeoglyphs.isEmpty()) {
            return String.format("There are no geoglyphs made by %s in this location.", constructionTechnique);
        }

        return String.format("Geoglyphs made by %s: %s",
                constructionTechnique,
                String.join(", ", matchingGeoglyphs));
    }

    public String getLargestGeoglyph() {
        if (this.geoglyphs.isEmpty()) {
            return String.format("No geoglyphs have yet been discovered in %s.", this.name);
        }

        Geoglyph largest = this.geoglyphs.stream()
                .max((g1, g2) -> Integer.compare(g1.getSize(), g2.getSize()))
                .orElse(null);

        return String.format("The largest geoglyph is %s with a length of %d meters.",
                largest.getName(),
                largest.getSize());
    }

    public Geoglyph getGeoglyphByName(String name) {
        return this.geoglyphs.stream()
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.geoglyphs.size();
    }

    public String getStatistics() {
        if (this.geoglyphs.isEmpty()) {
            return String.format("No geoglyphs have yet been discovered in %s.", this.name);
        }

        StringBuilder statistics = new StringBuilder()
                .append(String.format("Geoglyphs located in %s:", this.name))
                .append(System.lineSeparator());

        this.geoglyphs.forEach(g -> statistics
                .append("* ")
                .append(g.getName())
                .append(System.lineSeparator()));

        return statistics.toString().trim();
    }
}