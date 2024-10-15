import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Get Ranking
    public String getRanking() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Ranking: " + getRanking();
    }
}

public class StudentManagement {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students");
            System.out.println("6. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> deleteStudent();
                case 4 -> searchStudent();
                case 5 -> sortStudents();
                case 6 -> displayAllStudents();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks (0-10): ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // Edit an existing student's information
    private static void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.id == id) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Marks (0-10): ");
                double marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                student.name = name;
                student.marks = marks;
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete a student by ID
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        students.removeIf(student -> student.id == id);
        System.out.println("Student deleted successfully!");
    }

    // Search for a student by ID
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.id == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Sort students by ID, Name, or Marks
    private static void sortStudents() {
        System.out.println("Sort by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Marks");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> students.sort(Comparator.comparingInt(s -> s.id));
            case 2 -> students.sort(Comparator.comparing(s -> s.name.toLowerCase()));
            case 3 -> students.sort(Comparator.comparingDouble(s -> s.marks));
            default -> {
                System.out.println("Invalid choice. Please try again.");
                return;
            }
        }
        System.out.println("Students sorted successfully!");
    }

    // Display all students
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
