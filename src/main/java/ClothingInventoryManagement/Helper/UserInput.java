package ClothingInventoryManagement.Helper;

import java.io.Console;
import java.lang.reflect.Field;

public class UserInput {
    public static <T> void InputIntoInstance(T sample) throws Exception{
        Class<?> tObj = sample.getClass();
        Field[] fields = tObj.getDeclaredFields();

        Console sc = System.console();
        try {
            for(Field field : fields) {
                System.out.println("Nhap " + field.getName());

                if (field.getType() == int.class) {
                    int data = Integer.parseInt(sc.readLine());
                    field.setInt(sample, data);
                }
                else {
                    String data = sc.readLine();
                    field.set(sample, data);
                }
            }
        }
        catch(Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình nhâp dữ liệu");
            throw e;
        }
    }
}
