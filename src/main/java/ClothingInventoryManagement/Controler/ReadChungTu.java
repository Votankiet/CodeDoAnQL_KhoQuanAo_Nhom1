package ClothingInventoryManagement.Controler;

import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ClothingInventoryManagement.Helper.ClassName;
import ClothingInventoryManagement.Helper.ManipulationFile;
import ClothingInventoryManagement.Helper.UserInput;
import ClothingInventoryManagement.Model.ChungTu;

public class ReadChungTu {
    public static ArrayList<ChungTu> readFromDataBase(Connection connection, String extend) {
        ArrayList<ChungTu> data = new ArrayList<ChungTu>();
        try {
            Statement stat = connection.createStatement();
            String query = "Select * from CHUNGTU " + extend;

            ResultSet res = stat.executeQuery(query);
            while(res.next()) {
                data.add(new ChungTu(res.getInt(2), res.getInt(3), res.getString(4), res.getString(5), res.getString(6)));
            }
            System.out.println("Tải dữ liệu về thành công");
            res.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return data;
    }
    public static ArrayList<ChungTu> readFromFile(String fileName) {
        ArrayList<String> listData = new ArrayList<String>();
        ArrayList<ChungTu> res = new ArrayList<ChungTu>();
        ChungTu atho = new ChungTu();

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
                ChungTu temp = new ChungTu(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
                res.add(temp);
            }
            catch(Exception e) {

            }
        }

        return res;
    }
    public static ArrayList<ChungTu> readFromKeyboad() {
        ArrayList<ChungTu> res = new ArrayList<ChungTu>();

        Console scr = System.console();

        System.out.println("Nhập số lượng bản ghi");
        int numberEntry = Integer.parseInt(scr.readLine());

        for(int i = 0; i < numberEntry; i ++) {
            System.out.println("Bản ghi " + (i + 1));
            ChungTu instance = new ChungTu();
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
