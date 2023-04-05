package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.HangHoa;

public class UpdateHangHoa {
    private Connection connection;

    public UpdateHangHoa(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void update(HangHoa data) {
        String sql = "UPDATE HANGHOA SET TENHANG=?, MAUSAC=?, KICHCO=?, DONGIA=?, XUATXU=? WHERE MAHANG=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.tenHang);
            statement.setString(2, data.mauSac);
            statement.setString(3, data.kichCo);
            statement.setInt(4, data.donGia);
            statement.setString(5, data.xuatXu);
            statement.setString(6, data.maHang);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công");
            }
            else {
                System.out.println("Không cập nhật được có thể do bạn nhập sai MAHANG");
            }
        }
        catch(Exception e) {
            System.out.println("Có lỗi xảy ra: " + e);
        }
    }
    public void update(ArrayList<HangHoa> list) {
        for(HangHoa data : list) {
            update(data);
        }
    }
}
