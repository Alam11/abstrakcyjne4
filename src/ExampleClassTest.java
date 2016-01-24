import org.junit.Test;

import java.util.Dictionary;
import java.util.HashSet;

import static org.junit.Assert.*;

public class ExampleClassTest {

    @Test
    public void fieldsAreNullBeforeInitialization() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        //then
        assertFalse(FieldsInitializationCheck.everyFieldInitialized(e));
    }

    @Test
    public void allNonPrimitiveFieldsAreInitialized() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.everyFieldInitialized(e));
    }

    @Test
    public void checkNumberOfPrimitiveFields() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.getNumberOfPrimitiveFields(e) == 1);
    }


    @Test
    public void gathersProperClassName() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        e.initalize();
        //when
        Dictionary d = FieldsInitializationCheck.prepareStatisticsDictionary(e);
        //then
        assertEquals(d.get("Name"), "ExampleClass");
        assertEquals(d.get("Number of array fields"), 0);
    }


}