import java.util.ArrayList;
import java.util.Scanner;
class Student {
    int ID;
    String name;
    int marks;

    Student(int ID, String name, int marks) {
        this.ID = ID;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID " + ID + ", Name: " + name + ", marks: " + marks;
    }
}

public class Studentrecord {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n Student Record Manmarksment System");
            System.out.println("1. Add Student record");
            System.out.println("2. view Student record");
            System.out.println("3. update Student record");
            System.out.println("4. Delete Student record");
            System.out.println("5. Exit from student record");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                 addStudent(); 
                 break;
                case 2: 
                displayStudents();
                 break;
                case 3: 
                updateStudent(); 
                break;
                case 4: 
                deleteStudent(); 
                break;
                case 5: 
                System.out.println("Exited sucessfully"); 
                break;
                default:
                 System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter student ID: ");
        int ID = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter student marks: ");
        int marks = sc.nextInt();

        studentList.add(new Student(ID, name, marks));
        System.out.println("Student record added successfully.");
    }

    static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int ID = sc.nextInt();
        sc.nextLine(); 
        for (Student s : studentList) {
            if (s.ID == ID) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter marks: ");
                int marks = sc.nextInt();
                s.name = newName;
                s.marks = marks;
                System.out.println("Student record updated successfully.");
                return;
            }
        }
        System.out.println("Student record not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int ID = sc.nextInt();
        for (Student s : studentList) {
            if (s.ID == ID) {
                studentList.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student record not found.");
    }
}
