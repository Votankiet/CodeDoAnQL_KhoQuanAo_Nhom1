package ClothingInventoryManagement.Controler;

import java.io.Console;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ClothingInventoryManagement.Helper.ClassName;
import ClothingInventoryManagement.Helper.ManipulationFile;
import ClothingInventoryManagement.Helper.UserInput;
import ClothingInventoryManagement.Model.HangHoa;

public class ReadHangHoa {
    public static ArrayList<HangHoa> readFromDataBase(Connection connection, String extend) {
        ArrayList<HangHoa> data = new ArrayList<HangHoa>();
        try {
            Statement stat = connection.createStatement();
            String query = "Select * from HANGHOA " + extend;
            ResultSet res = stat.executeQuery(query);
            while(res.next()) {
                data.add(new HangHoa(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5), res.getString(6)));
            }
            System.out.println("Tải dữ liệu về thành công");
            res.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return data;
    }
    public static ArrayList<HangHoa> readFromFile(String fileName) {
        ArrayList<String> listData = new ArrayList<String>();
        ArrayList<HangHoa> res = new ArrayList<HangHoa>();
        HangHoa atho = new HangHoa();

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
                HangHoa temp = new HangHoa(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]);
                res.add(temp);
            }
            catch(Exception e) {

            }
        }

        return res;
    }

    public static ArrayList<HangHoa> readFromKeyboad() {
        ArrayList<HangHoa> res = new ArrayList<HangHoa>();

        Console scr = System.console();

        System.out.println("Nhập số lượng bản ghi");
        int numberEntry = Integer.parseInt(scr.readLine());

        for(int i = 0; i < numberEntry; i ++) {
            System.out.println("Bản ghi " + (i + 1));
            HangHoa instance = new HangHoa();
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
