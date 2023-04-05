package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.Console;
import java.util.ArrayList;

import ClothingInventoryManagement.Helper.ClassName;
import ClothingInventoryManagement.Helper.ManipulationFile;
import ClothingInventoryManagement.Helper.UserInput;
import ClothingInventoryManagement.Model.XuatXu;

public class ReadXuatXu {
    public static ArrayList<XuatXu> readFromDataBase(Connection connection, String extend) {
        ArrayList<XuatXu> data = new ArrayList<XuatXu>();
        try {
            Statement stat = connection.createStatement();
            String query = "Select * from XuatXu " + extend;
            ResultSet res = stat.executeQuery(query);
            while(res.next()) {
                data.add(new XuatXu(res.getString(1), res.getString(2)));
            }
            System.out.println("Tải dữ liệu về thành công");
            res.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return data;
    }

    public static ArrayList<XuatXu> readFromFile(String fileName) {
        ArrayList<String> listData = new ArrayList<String>();
        ArrayList<XuatXu> res = new ArrayList<XuatXu>();
        XuatXu atho = new XuatXu();

        if(!ClassName.getNameWithFileName(fileName).equalsIgnoreCase(ClassName.getNameWithClass(atho))) {
            System.out.println("Nhập tên file không đúng định dạng");
            
            return res;
        }

        listData = ManipulationFile.reader(fileName);

        for(String data : listData) {
            String[] parts = data.split("\t");
            if(parts.length == 0) {
                System.out.println("Có lỗi xảy ra");
                break;
            }
            try {
                XuatXu temp = new XuatXu(parts[0], parts[1]);
                res.add(temp);
            }
            catch(Exception e) {

            }
            
        }

        return res;
    }

    public static ArrayList<XuatXu> readFromKeyboad() {
        ArrayList<XuatXu> res = new ArrayList<XuatXu>();

        Console scr = System.console();

        System.out.println("Nhập số lượng bản ghi");
        int numberEntry = Integer.parseInt(scr.readLine());

        for(int i = 0; i < numberEntry; i ++) {
            System.out.println("Bản ghi " + (i + 1));
            XuatXu instance = new XuatXu();
            try {
                UserInput.InputIntoInstance(instance);
            } catch (Exception e) {
                System.out.println("Có lỗi sảy ra và hệ thống đả hủy bản ghi " + (i + 1));
                continue;
            }
            
            res.add(instance);
        }
        return res;
    }
}
