import java.sql.*;

public class JDBCExample {

    // Database details
    static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        // INSERT
        insertEmployee("Gauri", "gauri@gmail.com", 30000);

        // READ
        readEmployees();

        // UPDATE
        updateEmployee(1, 35000);

        // DELETE
        deleteEmployee(1);

        // READ again
        readEmployees();
    }

    // INSERT
    public static void insertEmployee(String name, String email, double salary) {

        String sql = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void readEmployees() {

        String sql = "SELECT * FROM employee";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nEmployee Details:");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");

                System.out.println(
                        id + " | " + name + " | " + email + " | " + salary
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateEmployee(int id, double salary) {

        String sql = "UPDATE employee SET salary = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}