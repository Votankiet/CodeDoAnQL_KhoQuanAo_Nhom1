package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.ChungTu;

public class UpdateChungTu {
    private Connection connection;
    public UpdateChungTu(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void update(ChungTu data) {
        String sql = "UPDATE CHUNGTU SET SOLUONG=?, DONGIA=?  WHERE MAHANG=? AND MANCC=? AND MAXX=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, data.soLuong);
            statement.setInt(2, data.donGia);
            statement.setString(3, data.maHang);
            statement.setString(4, data.maNCC);
            statement.setString(5, data.maXX);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
            }
            else {
                System.out.println("Cập nhật dữ liêu thất bại vui lòng thử kiểm tra các mã bạn nhập có trùng khớp");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình cập nhật dữ liêu: " + e);
        }
    }

    public void update(ArrayList<ChungTu> dataList) {
        for(ChungTu data : dataList) {
            update(data);
        }
    }
}
