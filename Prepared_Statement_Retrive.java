import java.sql.*;

public class Prepared_Statement_Retrive {
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
            String query = "SELECT marks FROM student WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                double marks  = resultSet.getDouble("marks");
                System.out.println("MARKS: "+marks);
            }else{
                System.out.println("Marks not Found");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}