
import java.util.*;
import java.io.*;

class Student {
    int roll;
    String name;
    int attended;
    int total;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
        this.attended = 0;
        this.total = 0;
    }

    double getPercentage() {
        if (total == 0) {
            return 0.0;
        }
        return (attended * 100.0) / total;
    }

    void display() {
        System.out.printf("%d | %s | Attendance: %d/%d | %.1f%%%n",
                roll, name, attended, total, getPercentage());
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "students.txt";

    // 1. Add a student
    static void addStudent() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (searchStudent(roll) != null) {
            System.out.println("Student already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        Student s = new Student(roll, name);
        students.add(s);

        System.out.println("Student added. " + roll + " | " + name);
    }

    // Search student using linear search
    static Student searchStudent(int roll) {

        for (Student s : students) {
            if (s.roll == roll) {
                return s;
            }
        }

        return null;
    }

    // 2. Mark attendance
    static void markAttendance() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student selected = searchStudent(roll);

        if (selected == null) {
            System.out.println("Roll " + roll + " not found.");
            return;
        }

        System.out.print("Enter P for Present or A for Absent: ");
        String status = sc.nextLine().trim();

        if (!status.equalsIgnoreCase("P") &&
            !status.equalsIgnoreCase("A")) {
            System.out.println("Invalid attendance status.");
            return;
        }

        // A new class has been conducted for all students
        for (Student s : students) {
            s.total++;
        }

        if (status.equalsIgnoreCase("P")) {
            selected.attended++;
        }

        System.out.println("Attendance marked successfully.");
        selected.display();
    }

    // 3. Search and display student
    static void searchAndDisplay() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student s = searchStudent(roll);

        if (s == null) {
            System.out.println("Roll " + roll + " not found.");
        } else {
            s.display();
        }
    }

    // 4. Display defaulters (below 75%)
    static void displayDefaulters() {

        System.out.println("\n--- Defaulter Students ---");

        boolean found = false;

        for (Student s : students) {
            if (s.getPercentage() < 75.0) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No defaulters found.");
        }
    }

    // 5. Sort students by attendance (high to low)
    static void sortByAttendance() {

        int n = students.size();

        // Bubble sort
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (students.get(j).getPercentage() <
                    students.get(j + 1).getPercentage()) {

                    Student temp = students.get(j);

                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n--- Students Sorted by Attendance ---");

        for (Student s : students) {
            s.display();
        }
    }

    // Display all students
    static void displayAllStudents() {

        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Load data from file
    static void loadData() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 4) {
                    continue;
                }

                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                int attended = Integer.parseInt(data[2]);
                int total = Integer.parseInt(data[3]);

                Student s = new Student(roll, name);
                s.attended = attended;
                s.total = total;

                students.add(s);
            }

            System.out.println("Student data loaded successfully.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading student data.");
        }
    }

    // Save data to file
    static void saveData() {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_NAME))) {

            for (Student s : students) {

                bw.write(s.roll + "," + s.name + ","
                        + s.attended + "," + s.total);

                bw.newLine();
            }

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }

    // Main method
    public static void main(String[] args) {

        loadData();

        while (true) {

            System.out.println("\n===== STUDENT ATTENDANCE MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Search Student");
            System.out.println("4. Display Defaulters");
            System.out.println("5. Sort by Attendance (High to Low)");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    markAttendance();
                    break;

                case 3:
                    searchAndDisplay();
                    break;

                case 4:
                    displayDefaulters();
                    break;

                case 5:
                    sortByAttendance();
                    break;

                case 6:
                    displayAllStudents();
                    break;

                case 7:
                    saveData();
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
