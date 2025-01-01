package JA11ExamPreparation.E013Geoglyphs;

import java.util.HashSet;
import java.util.Set;

public class Location {

    private String name;
    private Set<Geoglyph> geoglyphs;

    public Location(String name) {
        this.name = name;
        this.geoglyphs = new HashSet<>();
    }

    public void addGeoglyph(Geoglyph geoglyph) {
        if (geoglyphs.contains(geoglyph)) {
            throw new IllegalArgumentException("This geoglyph exists in the location!");
        }
        else {
            this.geoglyphs.add(geoglyph);
            System.out.println(geoglyph + " added to " + this.name);
        }
    }

    public boolean removeGeoglyph(Geoglyph geoglyph) {
        if (!geoglyphs.contains(geoglyph)) {
            return false;
        }
        else {
            this.geoglyphs.remove(geoglyph);
            return true;
        }
    }

    public String getGeoglyphsByConstructionTechnique(String constructionTechnique) {
        return 
    }

}
