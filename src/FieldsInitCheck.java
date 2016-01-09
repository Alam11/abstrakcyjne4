import java.lang.reflect.Field;

/**
 * Created by Piotrek on 2016-01-09.
 */
public class FieldsInitCheck {
    public static boolean areFieldsInitialized(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        boolean isInitialized = true;
        for(Field f : fields){
            f.setAccessible(true);
            if (isInitialized){
                isInitialized = f.get(o) != null;
            }
        }
        return isInitialized;
    }
}
