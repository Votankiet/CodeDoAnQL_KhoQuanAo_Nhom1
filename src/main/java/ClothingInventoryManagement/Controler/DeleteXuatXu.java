package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DeleteXuatXu {
    private Connection connection;

    public DeleteXuatXu(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void delete(String id) {
        String sql = "DELETE FROM XUATXU WHERE MAXX=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa thành công");
            }
            else {
                System.out.println("Không xóa được có thể do bạn nhập sai MAXX");
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
