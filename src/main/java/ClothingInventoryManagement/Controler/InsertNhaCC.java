package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.NhaCC;

public class InsertNhaCC {
    private Connection connection;
    public InsertNhaCC(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void insert(NhaCC data) {
        String sql = "INSERT INTO NHACC (MANCC, TENNCC, DIACHI, SDT, EMAIL) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.maNCC);
            statement.setString(2, data.tenNCC);
            statement.setString(3, data.diaChi);
            statement.setString(4, data.std);
            statement.setString(5, data.email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm dữ liệu thành công");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình thêm dữ liêu: " + e);
        }
    }

    public void insert(ArrayList<NhaCC> dataList) {
        for(NhaCC data : dataList) {
            this.insert(data);
        }
    }
}
