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

    public static int getNumberOfEumFields(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        int enumNumber = 0;
        for(Field f : fields){
            f.setAccessible(true);
            if (f.get(o).getClass().isEnum()){
                enumNumber += 1;
            }
        }
        return enumNumber;
    }

    public static int getNumberOfFields(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        return  fields.length;
    }

    public static int getNumberOfPrimitiveFields(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        int primitiveNumber = 0;
        for(Field f : fields){
            f.setAccessible(true);
            if (f.getType().isPrimitive()){
                primitiveNumber += 1;
            }
        }
        return primitiveNumber;
    }

    public static int getAvailableMethodsNumber(Object o) throws IllegalAccessException {
        return o.getClass().getDeclaredMethods().length;
    }

    public static int getNumberOfNonPrimitive(Object o) throws IllegalAccessException {
        return getNumberOfFields(o) - getNumberOfPrimitiveFields(o);
    }


    public static String getClassName(Object o) throws IllegalAccessException {
        return o.getClass().getName();
    }

    public static void printClassStats(Object o) throws IllegalAccessException {
        System.out.println(o.getClass().getName());
        System.out.println("All fields :" + getNumberOfFields(o));
        System.out.println("Primitive: " + getNumberOfPrimitiveFields(o));
        System.out.println("Non primitive: " + getNumberOfNonPrimitive(o));
        System.out.println("Number of available methods: " + getAvailableMethodsNumber(o));
    }


}
