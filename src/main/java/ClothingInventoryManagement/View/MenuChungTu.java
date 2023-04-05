package ClothingInventoryManagement.View;

import java.io.Console;
import java.sql.Connection;
import java.util.ArrayList;

import ClothingInventoryManagement.Controler.DeleteChungTu;
import ClothingInventoryManagement.Controler.InsertChungTu;
import ClothingInventoryManagement.Controler.ReadChungTu;
import ClothingInventoryManagement.Controler.UpdateChungTu;
import ClothingInventoryManagement.Helper.ClassName;
import ClothingInventoryManagement.Helper.DataFormat;
import ClothingInventoryManagement.Helper.ManipulationFile;
import ClothingInventoryManagement.Model.ChungTu;

public class MenuChungTu {
    public static void generate(Connection connection) {
        boolean menuExit = false;
        ArrayList<ChungTu> data = new ArrayList<ChungTu>();
        ChungTu sample = new ChungTu();

        while(!menuExit) {
            ClearConsole.clear();
            System.out.println("___________BẢNG CHỨNG TỪ_________");
            System.out.println("1. Tải dữ liệu từ database");
            System.out.println("2. Lấy dữ liệu từ file và thêm vào database");
            System.out.println("3. Thêm dữ liệu từ bàn phím");
            System.out.println("4. Xem bảng và xuất ra file");
            System.out.println("5. Cập nhật dữ liệu");
            System.out.println("6. Xóa dữ liệu");
            System.out.println("7. Tìm dữ liệu");
            System.out.println("8. Thoát");
            System.out.println("__________________________________");
            
            Console c = System.console();
            int choise = Integer.parseInt(c.readLine());

            switch (choise) {
                case 1:
                {
                    ClearConsole.clear();
                    String extend = "";
                    System.out.println("Bạn có cần sắp xếp dữ liêu không (y/n)");
                    String hasSort = c.readLine();
                    if(hasSort.equalsIgnoreCase("y")) {
                        ArrayList<String> propertyName = ClassName.getClassPropertyName(sample);
                        extend += "order by ";
                        System.out.println("_________Sắp xếp theo_____________");
                        for(int i = 0; i < propertyName.size(); i++) {
                            System.out.println((i + 1) + ". " + propertyName.get(i));
                        }
                        System.out.println("__________________________________");
                        try {
                            int sortCol = Integer.parseInt(c.readLine());
                            if(sortCol > propertyName.size()) sortCol = 1;
                            extend += propertyName.get(sortCol - 1).toUpperCase();
                        }
                        catch (Exception e) {
                            extend += propertyName.get(0);
                            System.out.println("Nhập sai hệ thống đã chọn cột sắp xếp mặc định");
                        }
                        System.out.println("Sắp xếp theo thứ tự nào");
                        System.out.println("1. ASC");
                        System.out.println("2. DESC");
                        
                        
                        try {
                            int orderChoise = Integer.parseInt(c.readLine()) ;
                            if(orderChoise == 1) extend += " ASC";
                            else extend += " DESC";
                        }
                        catch (Exception e) {
                            extend += " ASC";
                            System.out.println("Nhập sai hệ thống đã chọn thứ tự sắp xếp mặc định");
                        }
                    }
                    
                    data = ReadChungTu.readFromDataBase(connection, extend);
                    
                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 2:
                {
                    ClearConsole.clear();
                    System.out.println("Nhập tên file ");
                    String fileName = c.readLine();
                    ArrayList<ChungTu> temp = new ArrayList<ChungTu>();
                    temp = ReadChungTu.readFromFile(fileName);

                    if(temp.size() > 0) {
                        ShowChungTu.view(temp);
                        System.out.print("Xác nhân thêm vào database (y/n)");
                        String insertIntoDatabaseComfirm = c.readLine();
                        
                        if(insertIntoDatabaseComfirm.equalsIgnoreCase("y")) {
                            InsertChungTu insert = new InsertChungTu(connection);
                            insert.insert(temp);
                        }
                    }
                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 3:
                {
                    ClearConsole.clear();
                    ArrayList<ChungTu> temp = new ArrayList<ChungTu>();
                    temp = ReadChungTu.readFromKeyboad();

                    if(temp.size() > 0) {
                        ShowChungTu.view(temp);
                        System.out.print("Xác nhận thêm vào database (y/n)");
                        String insertIntoDatabaseComfirm = c.readLine();
                        
                        if(insertIntoDatabaseComfirm.equalsIgnoreCase("y")) {
                            InsertChungTu insert = new InsertChungTu(connection);
                            insert.insert(temp);
                        }
                    }
                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 4:
                {
                    ClearConsole.clear();
                    ShowChungTu.view(data);
                    System.out.println("Bạn có muốn xuất bảng dữ liệu ra file không (y/n)");
                    String exportingDataToFileComfirm = c.readLine();
                    if(exportingDataToFileComfirm.equalsIgnoreCase("y")) {
                        String fileName = "ChungTu";
                        ManipulationFile.Writer(fileName, DataFormat.Format(data));
                    }
                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 5:
                {
                    ClearConsole.clear();
                    ArrayList<ChungTu> temp = new ArrayList<ChungTu>();
                    System.out.println("Yêu cầu nhập đầy đủ dữ liệu để cập nhật và đảm bảo các mã phải có trong bảng");
                    System.out.println("Ấn phím ENTER để tiếp tục");
                    c.readLine();
                    temp = ReadChungTu.readFromKeyboad();

                    if(temp.size() > 0) {
                        ShowChungTu.view(temp);
                        System.out.print("Xác nhận update dữ liệu vào database (y/n)");
                        String updateIntoDatabaseComfirm = c.readLine();
                        
                        if(updateIntoDatabaseComfirm.equalsIgnoreCase("y")) {
                            UpdateChungTu insert = new UpdateChungTu(connection);
                            insert.update(temp);
                        }
                    }
                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 6:
                {
                    ClearConsole.clear();
                    ArrayList<ChungTu> temp = new ArrayList<ChungTu>();
                    System.out.println("Yêu cầu nhập đầy đủ các mã để xóa và đảm bảo các mã phải có trong bảng");
                    System.out.println("Ấn phím ENTER để tiếp tục");
                    c.readLine();
                    
                    System.out.println("Nhập số bản ghi cần xóa");
                    
                    try {
                        int numberIntance = Integer.parseInt(c.readLine());

                        for(int i = 0; i < numberIntance; i++) {
                            ChungTu instance = new ChungTu();
                            System.out.println("Nhập bản ghi " + (i + 1));
                            System.out.println("Nhập mã hàng");
                            instance.maHang = c.readLine();
                            System.out.println("Nhập mã nhà cung cấp");
                            instance.maNCC = c.readLine();
                            System.out.println("Nhập mã xuất xứ");
                            instance.maXX = c.readLine();
                            temp.add(instance);
                        }
                    } catch (Exception e) {
                        System.out.println("Đã xảy ra lỗi có thể do bạn nhập số bản ghi hoặc mã không hợp lệ");
                        System.out.println("Ấn phím ENTER để thoát");
                        c.readLine();
                        break;
                    }

                    if(temp.size() > 0) {
                        ShowChungTu.view(temp);
                        System.out.print("Xác nhận xóa dữ liệu database (y/n)");
                        String deleteDatabaseComfirm = c.readLine();
                        
                        if(deleteDatabaseComfirm.equalsIgnoreCase("y")) {
                            DeleteChungTu del = new DeleteChungTu(connection);
                            del.delete(temp);
                        }
                    }
                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 7:
                {
                    ClearConsole.clear();
                    ArrayList<ChungTu> temp = new ArrayList<ChungTu>();
                    System.out.println("Đảm bảo rằng là bạn đã tải dữ liệu từ cơ sở dữ liệu nếu không vui lòng thực hiên lựa chọn 1");
                    System.out.println("Bạn đã tải dữ liệu về chưa? (y/n)");
                    String hasDownDataFromDatabase = c.readLine();
                    if(hasDownDataFromDatabase.equalsIgnoreCase("n")) {
                        break;
                    }
                    System.out.println("Ấn phím ENTER để tiếp tục");
                    c.readLine();
                    
                    ChungTu instance = new ChungTu();
                    System.out.println("Nhập các mã để tìm dữ liệu");
                    System.out.println("Nhập mã hàng");
                    instance.maHang = c.readLine();
                    System.out.println("Nhập mã nhà cung cấp");
                    instance.maNCC = c.readLine();
                    System.out.println("Nhập mã xuất xứ");
                    instance.maXX = c.readLine();
                    
                    for(ChungTu i : data) {
                        if(DataFormat.NormalizeString(i.maHang).equalsIgnoreCase(instance.maHang) && DataFormat.NormalizeString(i.maNCC).equalsIgnoreCase(instance.maNCC) && DataFormat.NormalizeString(i.maXX).equalsIgnoreCase(instance.maXX)) {
                            temp.add(i);
                        }
                    }

                    if(temp.size() > 0) {
                        System.out.println("Đã tìm thấy");
                        ShowChungTu.view(temp);
                    }
                    else {
                        System.out.println("Không tìm thấy");
                    }

                    System.out.println("Ấn phím ENTER để thoát");
                    c.readLine();
                    break;
                }
                case 8:
                {
                    menuExit = true;
                    break;
                }
            
                default:
                    break;
            }
        }
    }
}
