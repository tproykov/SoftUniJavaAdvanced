package JA11ExamPreparation.E02_20_Oct_2024.E023WorldOfTanks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Terrain {

    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.tanks = new ArrayList<>();
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public String addTank(Tank tank) {

        for (Tank t : tanks) {
            if (t.getBrand().equals(tank.getBrand()) && t.getModel().equals(tank.getModel())) {
                return "Tank with this brand and model already exists!";
            }
        }

        if (this.type.equals("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }

        tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public boolean removeTank(String brand, String model) {
        for (Tank t : tanks) {
            if (t.getBrand().equals(brand) && t.getModel().equals(model)) {
                tanks.remove(t);
                return true;
            }
        }
        return false;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<Tank> tanks = getTanks().stream().filter(t -> t.getBarrelCaliber() > barrelCaliber).toList();
        List<String> tankBrands = tanks.stream().map(Tank::getBrand).toList();

        return !tankBrands.isEmpty()
                ? String.format("Tanks with caliber more than %dmm: ", barrelCaliber)
                    + String.join(", ", tankBrands.toString().replaceAll("[\\[\\]]", ""))
                : "There are no tanks with the specified caliber.";
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        return tanks.stream().filter(t -> t.getBrand().equals(brand) && t.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public String getTheMostArmoredTank() {
        Tank mostArmoredTank = tanks.stream().max(Comparator.comparing(Tank::getArmor)).orElse(null);
        assert mostArmoredTank != null;
        return String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                mostArmoredTank.getBrand(),
                mostArmoredTank.getModel(),
                mostArmoredTank.getArmor());
    }

    public int getCount() {
        return tanks.size();
    }

    public String getStatistics() {

        StringBuilder stringbuilder = new StringBuilder();

        if (tanks.isEmpty()) {
            stringbuilder.append("There are no tanks in the ").append(toLowerCase()).append(".");
        } else {
            stringbuilder.append("Tanks located in the ").append(toLowerCase()).append(":");
            for (Tank tank : tanks) {
                stringbuilder.append("\n");
                stringbuilder.append("-- ").append(tank.getBrand()).append(" ").append(tank.getModel());
            }
        }
        return stringbuilder.toString();
    }

    private String toLowerCase() {
        return String.format(this.type).toLowerCase();
    }


}
