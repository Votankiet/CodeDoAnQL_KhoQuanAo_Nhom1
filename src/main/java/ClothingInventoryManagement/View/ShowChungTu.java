package ClothingInventoryManagement.View;

import java.util.ArrayList;

import ClothingInventoryManagement.Helper.CreateTable;
import ClothingInventoryManagement.Model.ChungTu;

public class ShowChungTu {
    public static void view(ArrayList<ChungTu> data) {
        System.out.println(CreateTable.createTable(data));
    }
}
