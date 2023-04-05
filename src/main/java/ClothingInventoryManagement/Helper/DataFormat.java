package ClothingInventoryManagement.Helper;

import java.util.ArrayList;
import java.lang.reflect.Field;

public class DataFormat {
    public static <T> String Format(ArrayList<T> array) {
        String res = "";

        if(array.size() == 0) return res;

        Class<?> tObj = array.get(0).getClass();
        Field[] fields = tObj.getDeclaredFields();
        
        for(T obj : array) {
            String tempR = "";
            try {
                for(Field field : fields) {
                    tempR += (NormalizeString(field.get(obj).toString()) + "\t");
                }
                tempR = (tempR.substring(0, tempR.length() - 1) + "\n");
            }
            catch(Exception e) {
                System.out.println("Có lỗi xảy ra");
            }
            res += tempR;
        }

        return res;
    }
    public static String NormalizeString(String input) {
        String output = input.trim();
        return output;
    } 
}
