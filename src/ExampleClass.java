import javafx.event.Event;

import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Created by Piotrek on 2016-01-08.
 */

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}

public class ExampleClass {
    private NullPointer local;
    private int num;
    private HashSet e;
    public HashSet ex;
    private LinkedHashMap l;
    private String s;
    private String h;
    private Day d;
    private int[] a;

    ExampleClass(){
        num = 0;
        e = null;
        ex = new HashSet();
        local = new NullPointer();
        d = Day.MONDAY;
    }

    public void initalize(){
        e = new HashSet();
        l = new LinkedHashMap();
        s = "sdf";
        h = "asdf";
        a = new int[1];
    }
}
