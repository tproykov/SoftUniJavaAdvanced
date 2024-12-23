package JA06DefiningClasses.E02CompanyRoster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
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