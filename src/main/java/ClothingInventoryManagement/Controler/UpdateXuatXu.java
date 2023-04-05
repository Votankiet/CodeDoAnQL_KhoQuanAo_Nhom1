package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.XuatXu;

public class UpdateXuatXu {
    private Connection connection;

    public UpdateXuatXu(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void update(XuatXu data) {
        String sql = "UPDATE XUATXU SET TEN=? WHERE MAXX=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.ten);
            statement.setString(2, data.maXX);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công");
            }
            else {
                System.out.println("Không cập nhật được có thể do bạn nhập sai MAXX");
            }
        }
        catch(Exception e) {
            System.out.println("Có lỗi xảy ra: " + e);
        }
    }
    public void update(ArrayList<XuatXu> list) {
        for(XuatXu data : list) {
            update(data);
        }
    }
}
