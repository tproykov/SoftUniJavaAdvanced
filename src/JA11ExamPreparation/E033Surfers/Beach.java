package JA11ExamPreparation.E033Surfers;

import java.util.ArrayList;
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
        }
        else if (surfboardsForRent == 0) {
            System.out.println("There are no free surfboards.");
        }
        else {
            surfers.add(surfer);
            surfboardsForRent--;
        }
    }

    public boolean removeSurfer(String name) {
        if (surfers.contains(name)) {
            surfers.remove(name);
            return true;
        }
        return false;
    }




}
