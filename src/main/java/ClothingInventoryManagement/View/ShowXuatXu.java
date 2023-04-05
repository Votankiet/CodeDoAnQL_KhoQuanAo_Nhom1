package ClothingInventoryManagement.View;

import java.util.ArrayList;
import ClothingInventoryManagement.Helper.CreateTable;
import ClothingInventoryManagement.Model.XuatXu;

public class ShowXuatXu {
    public static void view(ArrayList<XuatXu> data) {
        System.out.println(CreateTable.createTable(data));
    }
}
