import javafx.event.Event;

import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Created by Piotrek on 2016-01-08.
 */
public class ExampleClass {
    private NullPointer local;
    private int num;
    private HashSet e;
    public HashSet ex;
    private LinkedHashMap l;
    private String s;
    private String h;

    ExampleClass(){
        num = 0;
        e = null;
        ex = new HashSet();
        local = new NullPointer();
    }

    public void init(){
        e = new HashSet();
        l = new LinkedHashMap();
        s = "sdf";
        h = "asdf";
    }
}
