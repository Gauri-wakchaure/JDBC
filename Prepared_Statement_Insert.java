import java.sql.*;

public class Prepared_Statement_Insert {

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
               // Statement statement = connection.createStatement();
            String query = "INSERT INTO student(name, age, marks) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Ankita");
            preparedStatement.setInt(2, 21);
            preparedStatement.setDouble(3, 78.11);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0) {
                System.out.println("Data Inserted Successfully");
            }else {
                System.out.println("Data not Inserted");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}