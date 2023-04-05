package ClothingInventoryManagement.Helper;

import java.util.ArrayList;
import de.vandermeer.asciitable.AsciiTable;
import java.lang.reflect.Field;

public class CreateTable {
    public static <T> String createTable(ArrayList<T> array) {
        AsciiTable at = new AsciiTable();
        if(array.size() == 0) return "";

        Class<?> tObj = array.get(0).getClass();
        Field[] fields = tObj.getDeclaredFields();

        Object[] titles;
        ArrayList<Object> temp = new ArrayList<Object>();
        for(Field field : fields) {
            temp.add(field.getName());
        }
        titles = temp.toArray();
        at.addRule();
        at.addRow(titles);
        at.addRule();
        
        for(T obj : array) {
            Object[] row;
            ArrayList<Object> tempR = new ArrayList<Object>();
            try {
                for(Field field : fields) {
                    tempR.add(field.get(obj));
                }
            }
            catch(Exception e) {
                System.out.println("Có lỗi xảy ra");
            }
            row = tempR.toArray();
            at.addRow(row);
            at.addRule();
        }

        return at.render();
    }    
}
