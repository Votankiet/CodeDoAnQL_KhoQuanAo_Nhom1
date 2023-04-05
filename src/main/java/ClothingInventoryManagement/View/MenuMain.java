package ClothingInventoryManagement.View;

import java.io.Console;
import java.sql.Connection;

public class MenuMain {
    public static void generate(Connection connection) {
        boolean menuExit = false;

        while(!menuExit) {
            ClearConsole.clear();
            System.out.println("___________CHƯƠNG TRÌNH QUẢN LÝ KHO HÀNG_________");
            System.out.println("1. Thao tác trên bảng CHỨNG TỪ");
            System.out.println("2. Thao tác trên bảng HÀNG HÓA");
            System.out.println("3. Thao tác trên bảng NHÀ CUNG CẤP");
            System.out.println("4. Thao tác trên bảng XUẤT XỨ");
            System.out.println("5. Thoát");
            System.out.println("_________________________________________________");
            
            Console c = System.console();
            int choise = Integer.parseInt(c.readLine());
            switch(choise) {
                case 1:
                {
                    MenuChungTu.generate(connection);
                    break;
                }
                case 2:
                {
                    MenuHangHoa.generate(connection);
                    break;
                }
                case 3:
                {
                    MenuNhaCC.generate(connection);
                    break;
                }
                case 4:
                {
                    MenuXuatXu.generate(connection);
                    break;
                }
                case 5:
                {
                    menuExit = true;
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
    }
}
