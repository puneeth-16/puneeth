import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {
   
    static final String URL = "jdbc:mysql://localhost:3306/employee_db"; 
    static final String USER = "root"; 
    static final String PASS = "";   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            while (true) {
                System.out.println("\n===== Employee Management =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1 -> addEmployee(con, sc);
                    case 2 -> viewEmployees(con);
                    case 3 -> updateEmployee(con, sc);
                    case 4 -> deleteEmployee(con, sc);
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    private static void addEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter designation: ");
        String designation = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, designation);
        ps.setDouble(3, salary);
        ps.executeUpdate();
        System.out.println("Employee added successfully!");
    }

   
    private static void viewEmployees(Connection con) throws SQLException {
        String sql = "SELECT * FROM employees";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Employee List ---");
        while (rs.next()) {
            System.out.printf("ID: %d | Name: %s | Designation: %s | Salary: %.2f\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("designation"),
                    rs.getDouble("salary"));
        }
    }

  
    private static void updateEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new designation: ");
        String designation = sc.nextLine();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employees SET name=?, designation=?, salary=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, designation);
        ps.setDouble(3, salary);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    
    private static void deleteEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee ID not found.");
        }
    }
}
