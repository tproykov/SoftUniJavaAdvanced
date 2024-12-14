package JA03SetsAndMapsAdvanced;

import java.util.*;

public class L05AverageStudentGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 1; i <= n; i++) {

            String[] studentDetails = scanner.nextLine().split("\\s+");
            String studentName = studentDetails[0];
            double studentGrade = Double.parseDouble(studentDetails[1]);

            if (!studentGrades.containsKey(studentName)) {
                studentGrades.put(studentName, new ArrayList<>());
                studentGrades.get(studentName).add(studentGrade);
            }
            else {
                studentGrades.get(studentName).add(studentGrade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {

            List<Double> grades = entry.getValue();

            System.out.print(entry.getKey() + " -> ");

            for (double grade : grades) {
                System.out.printf("%.2f ", grade);
            }

            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double average = sum / grades.size();

            System.out.printf("(avg: %.2f)\n", average);
        }
    }
}