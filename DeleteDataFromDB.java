import java.sql.*;

public class DeleteDataFromDB {

    private static final String url = "jdbc:mysql://localhost:3306/myjdbcdb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM student WHERE ID = 2";
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected>0) {
                System.out.println("Data Deleted Successfully");
            }else {
                System.out.println("Data not Deleted");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}