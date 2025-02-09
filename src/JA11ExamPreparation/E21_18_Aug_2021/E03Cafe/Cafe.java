package JA11ExamPreparation.E21_18_Aug_2021.E03Cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);

    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Employees working at Cafe ").append(name).append("\n");
        employees.stream().forEach(employee -> report.append(employee.toString()).append("\n"));
        return report.toString();
    }
}