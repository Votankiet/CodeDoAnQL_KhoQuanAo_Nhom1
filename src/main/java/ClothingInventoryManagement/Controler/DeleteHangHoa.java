package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DeleteHangHoa {
    private Connection connection;
    
    public DeleteHangHoa(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void delete(String id) {
        String sql = "DELETE FROM HANGHOA WHERE MAHANG=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa thành công");
            }
            else {
                System.out.println("Không xóa được có thể do bạn nhập sai MAHANG");
            }
        }
        catch(Exception e) {
            System.out.println("Có lỗi xãy ra: " + e);
        }
    }

    public void delete(ArrayList<String> list) {
        for(String id : list) {
            delete(id);
        }
    }
}
