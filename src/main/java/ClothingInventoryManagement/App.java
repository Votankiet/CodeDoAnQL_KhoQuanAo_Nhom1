package ClothingInventoryManagement;

import ClothingInventoryManagement.DatabaseConnection.*;
import java.sql.Connection;
import ClothingInventoryManagement.View.MenuMain;

public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:sqlserver://LAPTOP-BF9157I6\\SQLEXPRESS:1433;databaseName=KHOQUANAO;encrypt=false;trustServerCertificate=true";
        String user = "guest";
        String password = "123456";

        Connection connection = new Connecting(url, user, password).getConnection();
        if(connection == null) System.exit(0);
        MenuMain.generate(connection);
    }
}
