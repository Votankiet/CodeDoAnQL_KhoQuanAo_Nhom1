package ClothingInventoryManagement.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {
    private Connection connection;

    public Connecting(String url, String user, String password) {
        //Thiết lập kết nối đến database
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            System.out.println("Lỗi kết nối đến cơ sở dữ liệu");
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        if(connection != null) {
            System.out.println("Kết nối thành công");
        }
        return connection;
    }
}
