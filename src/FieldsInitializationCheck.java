import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Piotrek on 2016-01-09.
 */
public class FieldsInitializationCheck {

    private static final String DEFAULT_PACKAGE = "DEFAULT";

    public static boolean everyFieldInitialized(Object o) throws IllegalAccessException {
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

    public static int getNumberOfArrayFields(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        int arrayNumber = 0;
        for(Field f : fields){
            f.setAccessible(true);
            if (f.getType().isArray()){
                arrayNumber += 1;
            }
        }
        return arrayNumber;
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

    public static int getNumberOfConstructors(Object o) throws IllegalAccessException {
        return o.getClass().getConstructors().length;
    }

    public static String getPackageName(Object o) throws IllegalAccessException {
        Package p = o.getClass().getPackage();
        if (p == null){
            return DEFAULT_PACKAGE;
        } else {
            return p.getName();
        }
    }

    public static int getNumberOfImplementedInterfaces(Object o) throws IllegalAccessException {
        return o.getClass().getInterfaces().length;
    }

    public static boolean superclassIsObject(Object o) throws IllegalAccessException {
        return o.getClass().getSuperclass() == Object.class;
    }

    public static Dictionary prepareStatisticsDictionary(Object o) throws IllegalAccessException {
        Dictionary dict = new Hashtable();
        dict.put("Package name" , getPackageName(o));
        dict.put("Name", getClassName(o));
        dict.put("Number of fields", getNumberOfFields(o));
        dict.put("Number of primitive" , getNumberOfPrimitiveFields(o));
        dict.put("Number of non primitive " , getNumberOfNonPrimitive(o));
        dict.put("Number of available methods: " , getAvailableMethodsNumber(o));
        dict.put("Number of array fields" , getNumberOfArrayFields(o));
        dict.put("Number of enum fields" , getNumberOfEumFields(o));
        dict.put("Number of constructors" , getNumberOfConstructors(o));
        dict.put("Number of implemented interfaces" , getNumberOfImplementedInterfaces(o));
        dict.put("Is direct child of Object " , superclassIsObject(o));
        return dict;
    }


}
