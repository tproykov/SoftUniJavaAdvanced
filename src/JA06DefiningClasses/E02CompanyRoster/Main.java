package JA06DefiningClasses.E02CompanyRoster;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departmentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();

            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentName = tokens[3];

            Department department;

            if (departmentMap.containsKey(departmentName)) {
                department = departmentMap.get(departmentName);
            } else {
                department = new Department(departmentName);
                departmentMap.put(departmentName, department);
            }

            Employee employee;

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, departmentName, email, age);
                department.addEmployee(employee);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("\\d+")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, departmentName, age);
                    department.addEmployee(employee);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, departmentName, email);
                    department.addEmployee(employee);
                }
            } else {
                employee = new Employee(name, salary, position, departmentName);
                department.addEmployee(employee);
            }
        }

        Department department = departmentMap
                .values()
                .stream().max((d1, d2) -> Double.compare(d1.getAvgSalary(), d2.getAvgSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s\n", department.getName());
        department.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}