import java.sql.*; // Import SQL package 

public class MySQLConnection {
    public static void main(String[] args) { // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database name
        String user = "your_username"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        // Query to fetch all records from Employee table
        String query = "SELECT EmpID, Name, Salary FROM Employee";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement stmt = conn.createStatement();
            // Execute query and get results
            ResultSet rs = stmt.executeQuery(query);

            // Print results
            System.out.println("EmpID\tName\tSalary");
            while (rs.next()) {
                int empId = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(empId + "\t" + name + "\t" + salary);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        }
    }
}
