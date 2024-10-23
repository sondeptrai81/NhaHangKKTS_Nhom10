package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLiNhaHang;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "sapassword";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = connect();
            if (conn != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to connect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
