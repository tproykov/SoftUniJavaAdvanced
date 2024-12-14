package JA03SetsAndMapsAdvanced;

import java.util.*;

public class L08AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentsGrades = new TreeMap<>();


        for (int i = 0; i < n; i++) {

            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double average = sum / grades.length;
            studentsGrades.put(studentName, average);
        }

        for (Map.Entry<String, Double> entry : studentsGrades.entrySet()) {

            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}