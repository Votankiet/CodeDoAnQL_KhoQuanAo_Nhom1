package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.ChungTu;

public class DeleteChungTu {
    private Connection connection;
    public DeleteChungTu(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void delete(ChungTu data) {
        String sql = "DELETE FROM CHUNGTU WHERE MAHANG=? AND MANCC=? AND MAXX=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.maHang);
            statement.setString(2, data.maNCC);
            statement.setString(3, data.maXX);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa dữ liệu thành công");
            }
            else {
                System.out.println("Xóa dữ liêu thất bại vui lòng thử kiểm tra các mã bạn nhập có trùng khớp");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình xóa dữ liêu: " + e);
        }
    }

    public void delete(ArrayList<ChungTu> dataList) {
        for(ChungTu data : dataList) {
            delete(data);
        }
    }
}
