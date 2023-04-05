package ClothingInventoryManagement.Helper;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Field;

public class ClassName {
    public static String getNameWithFileName(String fileName) {
        Pattern pattern = Pattern.compile("(\\D+)(\\d+)"); // tìm các phần tử không phải số (\D+) và phần tử số (\d+)
        Matcher matcher = pattern.matcher(fileName);
        String className = "";
        if (matcher.find()) {
            className = matcher.group(1); // lấy phần tử không phải số
        }

        return className;
    }

    public static ArrayList<String> getClassPropertyName(Object obj) {
        Class<?> tObj = obj.getClass();
        Field[] fields = tObj.getDeclaredFields();
        ArrayList<String> res = new ArrayList<String>();
        for(Field field : fields) {
            res.add(field.getName());
        }

        return res;
    }

    public static String getNameWithClass(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
