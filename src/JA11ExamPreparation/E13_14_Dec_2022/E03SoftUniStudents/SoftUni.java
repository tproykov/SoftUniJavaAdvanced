package JA11ExamPreparation.E13_14_Dec_2022.E03SoftUniStudents;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (this.capacity > this.data.size() && !this.data.contains(student)) {
            this.data.add(student);
            return "Added student " + student.getFirstName() + " " + student.getLastName() + ".";
        }
        else if (this.data.contains(student)) {
            return "Student is already in the hall.";
        }
        else if (this.capacity == this.data.size()) {
            return "The hall is full.";
        }
        return null;
    }

    public String remove(Student student) {
        if (!this.data.contains(student)) {
            return "Student not found.";
        }
        else {
            this.data.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName() + ".";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();
        statistics.append("Hall size: ").append(this.capacity).append("\n");
        data.forEach(student -> statistics.append(student.toString()).append("\n"));

        return statistics.toString();
    }
}