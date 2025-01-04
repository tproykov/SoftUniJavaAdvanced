package JA11ExamPreparation.E033Surfers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Beach {

    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public void addSurfer(Surfer surfer) {

        if (!surfer.ownsASurfBoard() && surfer.getMoney() < 50) {
            System.out.println(surfer.getName() + " has not enough money to rent a surfboard.");
        } else if (surfboardsForRent == 0) {
            System.out.println("There are no free surfboards.");
        } else {
            surfers.add(surfer);
            surfboardsForRent--;
        }
    }

    public boolean removeSurfer(String name) {
        return surfers.removeIf(surfer -> surfer.getName().equals(name));
    }

    public String getMostExperiencedSurfer() {

        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }

        Surfer mostExperiencedSurfer = surfers.stream().max(Comparator.comparing(Surfer::getExperience)).get();

        return String.format("%s is most experienced surfer with %d years experience.",
                mostExperiencedSurfer.getName(), mostExperiencedSurfer.getExperience());
    }

    public Surfer getSurfer(String name) {
        return surfers.stream()
                .filter(surfer -> surfer.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return surfers.size();
    }

    public String getSurfersWithPersonalSurfBoards() {

        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }

        List<String> surfersWithPersonalSurfBoards = new ArrayList<>();
        for (Surfer surfer : surfers) {
            if (surfer.ownsASurfBoard()) {
                surfersWithPersonalSurfBoards.add(surfer.getName());
            }
        }

        return "Surfers who have their own surfboards: " + String.join(", ", surfersWithPersonalSurfBoards);
    }

    public String getReport() {





        return null;
    }



}









