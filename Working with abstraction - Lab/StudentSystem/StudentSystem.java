package workingwithabstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentData;

    public StudentSystem() {
        this.studentData = new HashMap<>();
    }

    public void ParseCommand(String[] command) {
        if (command[0].equals("Create")) {
            create(command);
        } else if (command[0].equals("Show")) {
            show(command[1]);
        }
    }

    private void show(String name) {
        if (studentData.containsKey(name)) {
            Student student = studentData.get(name);
            String view = " Very nice person.";
            if (student.getGrade() >= 5.00) {
                view = " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view = " Average student.";
            }
            System.out.println(student + view);
        }
    }

    private void create(String[] command) {
        String name = command[1];
        int age = Integer.parseInt(command[2]);
        double grade = Double.parseDouble(command[3]);
        if (!studentData.containsKey(name)) {
            Student student = new Student(name, age, grade);
            studentData.put(name, student);
        }
    }
}

