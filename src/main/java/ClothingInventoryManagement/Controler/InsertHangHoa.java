package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.HangHoa;

public class InsertHangHoa {
    private Connection connection;
    public InsertHangHoa(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void insert(HangHoa data) {
        String sql = "INSERT INTO HANGHOA (MAHANG, TENHANG, MAUSAC, KICHCO, DONGIA, XUATXU) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.maHang);
            statement.setString(2, data.tenHang);
            statement.setString(3, data.mauSac);
            statement.setString(4, data.kichCo);
            statement.setInt(5, data.donGia);
            statement.setString(6, data.xuatXu);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm dữ liệu thành công");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình thêm dữ liêu: " + e);
        }
    }

    public void insert(ArrayList<HangHoa> dataList) {
        for(HangHoa data : dataList) {
            this.insert(data);
        }
    }
}
