import java.sql.*;
import java.util.Scanner;

public class Insert_Multiple_Data {

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
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                System.out.println("Enter marks: ");
                Double marks = scanner.nextDouble();
                System.out.println("Enter more data(Y/N) ");
                String choice = scanner.next();
                String query = String.format("INSERT INTO student(name, age, marks) VALUES('%s', %d, %f)", name, age, marks);
                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")) {
                    break;
                }
            }
            int[] arr = statement.executeBatch();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}