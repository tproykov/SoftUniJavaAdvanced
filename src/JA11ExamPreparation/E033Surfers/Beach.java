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

    public String addSurfer(Surfer surfer) {

        if (surfers.stream().anyMatch(s -> s.getName().equals(surfer.getName()))) {
            throw new RuntimeException("This surfer already exists!");
        }

        if (!surfer.isOwnsASurfBoard()) {
            if (this.surfboardsForRent > 0) {
                if (surfer.getMoney() >= 50) {
                    this.surfboardsForRent--;
                } else {
                    return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
                }
            } else {
                return "There are no free surfboards.";
            }
        }
        surfers.add(surfer);

        return String.format("Surfer %s added.", surfer.getName());
    }

    public Boolean removeSurfer(String name) {
        return surfers.removeIf(surfer -> surfer.getName()
                .equals(name));
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

    public String getSurfersWithPersonalSurfboards() {

        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }

        List<String> surfersWithPersonalSurfboards = new ArrayList<>();
        for (Surfer surfer : surfers) {
            if (surfer.isOwnsASurfBoard()) {
                surfersWithPersonalSurfboards.add(surfer.getName());
            }
        }

        return "Surfers who have their own surfboards: " + String.join(", ", surfersWithPersonalSurfboards);
    }

    public String getReport() {
        if (this.surfers.isEmpty()) {
            return String.format("There are no surfers on %s beach.", this.name);
        }

        StringBuilder report = new StringBuilder();
        report.append(String.format("Beach %s was visited by the following surfers:\n", this.name));

        for (int i = 0; i < surfers.size(); i++) {
            Surfer surfer = surfers.get(i);
            String experience = surfer.getExperience() > 0
                    ? surfer.getExperience() + " years experience"
                    : "no experience";

            report.append(String.format("%d. %s with %s.\n", i + 1, surfer.getName(), experience));
        }

        return report.toString().trim(); // Remove trailing newline for clean output
    }
}