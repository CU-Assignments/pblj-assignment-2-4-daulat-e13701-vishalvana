package Project1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        try {
            StudentController controller = new StudentController();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Add Student  2. View Students  3. Update Marks  4. Delete Student  5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter Name: ");
                    sc.nextLine(); // Consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    controller.addStudent(new Student(0, name, dept, marks)); // Assuming class name is Student
                } 
                else if (choice == 2) {
                    List<Student> students = controller.getStudents();
                    System.out.println("\nStudentID | Name | Department | Marks");
                    System.out.println("-------------------------------------");
                    for (Student s : students) {
                        System.out.printf("%d | %s | %s | %.2f\n", s.getStudentID(), s.getName(), s.getDepartment(), s.getMarks());
                    }
                } 
                else if (choice == 3) {
                    System.out.print("Enter StudentID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Marks: ");
                    double marks = sc.nextDouble();
                    controller.updateStudentMarks(id, marks);
                } 
                else if (choice == 4) {
                    System.out.print("Enter StudentID to delete: ");
                    int id = sc.nextInt();
                    controller.deleteStudent(id);
                } 
                else if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                } 
                else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            sc.close(); // Close scanner after loop
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
