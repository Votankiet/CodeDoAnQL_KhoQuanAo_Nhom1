package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.XuatXu;

public class InsertXuatXu {
    private Connection connection;
    public InsertXuatXu(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void insert(XuatXu data) {
        String sql = "INSERT INTO XUATXU (MAXX, TEN) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.maXX);
            statement.setString(2, data.ten);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm dữ liệu thành công");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình thêm dữ liêu: " + e);
        }
    }

    public void insert(ArrayList<XuatXu> dataList) {
        for(XuatXu data : dataList) {
            this.insert(data);
        }
    }
}
