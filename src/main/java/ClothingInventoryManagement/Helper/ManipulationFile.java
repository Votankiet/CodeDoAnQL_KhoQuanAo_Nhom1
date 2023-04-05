package ClothingInventoryManagement.Helper;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class ManipulationFile {
    public static ArrayList<String> reader(String fileName) {

        ArrayList<String> res = new ArrayList<String>();

        try {
            File f = new File("D:\\Project\\ClothingInventory\\ClothingInventoryManagerment\\src\\main\\java\\ClothingInventoryManagement\\Stored\\" + fileName + ".txt");

            Scanner scanner = new Scanner(f);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                res.add(line);
            }

            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Có lỗi xảy ra hoặc file không tồn tại");
        }
        
        return res;
    }

    public static void Writer(String fileName, String data) {
        Date d = new Date();
        long time = d.getTime();
        String label = Long.toString(time);

        String fullFileName = fileName + label;

        String filePath = "D:\\Project\\ClothingInventory\\ClothingInventoryManagerment\\src\\main\\java\\ClothingInventoryManagement\\Stored\\" + fullFileName + ".txt";

        try {
            File newFile = new File(filePath);

            if(newFile.createNewFile()) {
                System.out.println("Tạo file: " + newFile.getName());
            }
            else {
                System.out.println("File đã tồn tại");
            }
        }
        catch(Exception e) {
            System.out.print("Có lỗi sảy ra trong quá trình tạo file: " + e);
        }

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(data);
            System.out.println("Xuất ra file thành công tên file của bạn là " + fullFileName + ".txt");
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình viết file: " + e);
        }
    }
}
