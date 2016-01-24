import java.util.HashSet;

/**
 * Created by Piotrek on 2016-01-24.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        HashSet<Integer> set = new HashSet<Integer>();
        System.out.println(FieldsInitializationCheck.prepareStatisticsDictionary(set));
    }
}
