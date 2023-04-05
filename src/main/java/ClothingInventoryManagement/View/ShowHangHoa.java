package ClothingInventoryManagement.View;

import java.util.ArrayList;
import ClothingInventoryManagement.Helper.CreateTable;
import ClothingInventoryManagement.Model.HangHoa;

public class ShowHangHoa {
    public static void view(ArrayList<HangHoa> data) {
        System.out.println(CreateTable.createTable(data));
    }
}
