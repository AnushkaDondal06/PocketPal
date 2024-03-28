import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // JDBC URL for Oracle
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Replace with your Oracle instance details

        // Database credentials
        String username = "system";
        String password = "anushka";

        Connection connection = null;

        try {
            // Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Open a connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement pr=connection.prepareStatement("create table anus(no int)");
            pr.executeUpdate();
            // Check if connection is successful
            if (connection != null) {
                System.out.println("Connected to Oracle database!");
            } else {
                System.out.println("Failed to connect to Oracle database!");
            }

            // You can now perform database operations using this connection

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
