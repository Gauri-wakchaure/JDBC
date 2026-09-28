import java.sql.*;
import java.util.Scanner;

public class Prepared_Statement_AddData {

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
            String query = "INSERT INTO student(name, age, marks) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                System.out.print("Enter marks: ");
                Double marks = scanner.nextDouble();
                System.out.print("Enter more data(Y/N) ");
                String choice = scanner.next();
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setDouble(3, marks);

                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N")) {
                    break;
                }
            }
            int[] arr = preparedStatement.executeBatch();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}