package JA06DefiningClasses.E02CompanyRoster;

import java.util.HashSet;
import java.util.Set;

public class Department {

    private String name;
    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAvgSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}