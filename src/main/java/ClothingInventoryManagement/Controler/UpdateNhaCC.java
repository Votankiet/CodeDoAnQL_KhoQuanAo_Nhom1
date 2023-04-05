package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ClothingInventoryManagement.Model.NhaCC;

public class UpdateNhaCC {
    private Connection connection;

    public UpdateNhaCC(Connection connection) {
        this.connection = connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void update(NhaCC data) {
        String sql = "UPDATE NHACC SET TENNCC=? DIACHI=? SDT=? EMAIL=? WHERE MANCC=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.tenNCC);
            statement.setString(2, data.diaChi);
            statement.setString(3, data.std);
            statement.setString(4, data.email);
            statement.setString(5, data.maNCC);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công");
            }
            else {
                System.out.println("Không cập nhật được có thể do bạn nhập sai MANCC");
            }
        }
        catch(Exception e) {
            System.out.println("Có lỗi xảy ra: " + e);
        }
    }
    public void update(ArrayList<NhaCC> list) {
        for(NhaCC data : list) {
            update(data);
        }
    }
}
