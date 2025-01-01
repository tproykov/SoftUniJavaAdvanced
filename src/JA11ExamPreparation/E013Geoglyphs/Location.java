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

    

}
