//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManagement {
    static Scanner scanner;
    static ArrayList<Student> students;

    public StudentManagement() {
    }

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
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    sortStudents();
                    break;
                case 6:
                    displayAllStudents();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(choice != 0);

    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks (0-10): ");
        double marks = scanner.nextDouble();
        scanner.nextLine();
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Iterator var1 = students.iterator();

        Student student;
        do {
            if (!var1.hasNext()) {
                System.out.println("Student not found.");
                return;
            }

            student = (Student)var1.next();
        } while(student.id != id);

        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Marks (0-10): ");
        double marks = scanner.nextDouble();
        scanner.nextLine();
        student.name = name;
        student.marks = marks;
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        students.removeIf((student) -> {
            return student.id == id;
        });
        System.out.println("Student deleted successfully!");
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Iterator var1 = students.iterator();

        Student student;
        do {
            if (!var1.hasNext()) {
                System.out.println("Student not found.");
                return;
            }

            student = (Student)var1.next();
        } while(student.id != id);

        System.out.println(student);
    }

    private static void sortStudents() {
        System.out.println("Sort by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Marks");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                students.sort(Comparator.comparingInt((s) -> {
                    return s.id;
                }));
                break;
            case 2:
                students.sort(Comparator.comparing((s) -> {
                    return s.name.toLowerCase();
                }));
                break;
            case 3:
                students.sort(Comparator.comparingDouble((s) -> {
                    return s.marks;
                }));
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        System.out.println("Students sorted successfully!");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            Iterator var0 = students.iterator();

            while(var0.hasNext()) {
                Student student = (Student)var0.next();
                System.out.println(student);
            }
        }

    }

    static {
        scanner = new Scanner(System.in);
        students = new ArrayList();
    }
}
