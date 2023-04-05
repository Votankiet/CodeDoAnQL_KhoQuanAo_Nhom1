package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.ChungTu;

public class InsertChungTu {
    private Connection connection;
    public InsertChungTu(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void insert(ChungTu data) {
        String sql = "INSERT INTO CHUNGTU (SOLUONG, DONGIA, MAHANG, MANCC, MAXX) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, data.soLuong);
            statement.setInt(2, data.donGia);
            statement.setString(3, data.maHang);
            statement.setString(4, data.maNCC);
            statement.setString(5, data.maXX);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm dữ liệu thành công");
            }
            else {
                System.out.println("Thêm dữ liêu thất bại");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình thêm dữ liêu: " + e);
        }
    }

    public void insert(ArrayList<ChungTu> dataList) {
        for(ChungTu data : dataList) {
            insert(data);
        }
    }
}
