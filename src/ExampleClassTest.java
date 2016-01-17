import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class ExampleClassTest {

    @Test
    public void isNullBeforeInit() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        //then
        assertFalse(FieldsInitCheck.areFieldsInitialized(e));
    }

    @Test
    public void isNotNullAfterInic() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.init();
        //then
        assertTrue(FieldsInitCheck.areFieldsInitialized(e));
    }

    @Test
    public void numOfPrimitiveFields() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.init();
        //then
        assertTrue(FieldsInitCheck.getNumberOfPrimitiveFields(e) == 1);
    }


    @Test
    public void printStats() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        HashSet<Integer> set = new HashSet<>();
        //when
        e.init();
        //then
        FieldsInitCheck.printClassStats(e);
    }


}