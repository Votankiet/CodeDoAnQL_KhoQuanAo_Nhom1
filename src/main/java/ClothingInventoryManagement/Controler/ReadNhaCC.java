package ClothingInventoryManagement.Controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.Console;
import java.util.ArrayList;

import ClothingInventoryManagement.Helper.ClassName;
import ClothingInventoryManagement.Helper.ManipulationFile;
import ClothingInventoryManagement.Helper.UserInput;
import ClothingInventoryManagement.Model.NhaCC;

public class ReadNhaCC {
    public static ArrayList<NhaCC> readFromDataBase(Connection connection, String extend) {
        ArrayList<NhaCC> data = new ArrayList<NhaCC>();
        try {
            Statement stat = connection.createStatement();
            String query = "Select * from NHACC " + extend;
            ResultSet res = stat.executeQuery(query);
            while(res.next()) {
                data.add(new NhaCC(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
            }
            System.out.println("Tải dữ liệu về thành công");
            res.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return data;
    }
    public static ArrayList<NhaCC> readFromFile(String fileName) {
        ArrayList<String> listData = new ArrayList<String>();
        ArrayList<NhaCC> res = new ArrayList<NhaCC>();
        NhaCC atho = new NhaCC();

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
                NhaCC temp = new NhaCC(parts[0], parts[1], parts[2], parts[3], parts[4]);
                res.add(temp);
            }
            catch(Exception e) {

            }
        }

        return res;
    }

    public static ArrayList<NhaCC> readFromKeyboad() {
        ArrayList<NhaCC> res = new ArrayList<NhaCC>();

        Console scr = System.console();

        System.out.println("Nhập số lượng bản ghi");
        int numberEntry = Integer.parseInt(scr.readLine());

        for(int i = 0; i < numberEntry; i ++) {
            System.out.println("Bản ghi " + (i + 1));
            NhaCC instance = new NhaCC();
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
