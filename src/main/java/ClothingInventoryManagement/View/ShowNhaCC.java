package ClothingInventoryManagement.View;

import java.util.ArrayList;
import ClothingInventoryManagement.Helper.CreateTable;
import ClothingInventoryManagement.Model.NhaCC;

public class ShowNhaCC {
    public static void view(ArrayList<NhaCC> data) {
        System.out.println(CreateTable.createTable(data));
    }
}
