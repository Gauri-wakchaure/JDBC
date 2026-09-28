import java.sql.*;

public class InsertDataToDB {
    
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
            String query = String.format("INSERT INTO STUDENT(name, age, marks) VALUES('%s', %o, %f)", "Priya", 23, 87.65);
            int rowsAffected = statement.executeUpdate(query);
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