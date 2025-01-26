package JA11ExamPreparation.E12_18_Feb_2023.E03SoftUniKnderGarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<Child>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }

    public boolean addChild(Child child) {
        if (this.capacity > registry.size()) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        return this.registry.removeIf(child -> child.getFirstName().equals(firstName));
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return this.registry.stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public String registryReport() {

        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder report = new StringBuilder();
        report.append("Registered children in ").append(this.name).append(":\n");

        for (int i = 0; i < sortedChildren.size(); i++) {
            report.append("--\n");
            report.append(sortedChildren.get(i));
            if (i < sortedChildren.size() - 1) {
                report.append("\n");
            }
        }

        return report.toString().trim();
    }
}