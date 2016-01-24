import org.junit.Test;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.LinkedList;

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
    public void checkNumberOfArrayFields() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.getNumberOfArrayFields(e) == 1);
    }


    @Test
    public void checkNumberOfEnumFields() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.getNumberOfEumFields(e) == 1);
    }

    @Test
    public void checkNumberOfNonPrimitiveFields() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.getNumberOfNonPrimitive(e) == 8);
    }

    @Test
    public void checkNumberOfConstuctors() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.getNumberOfConstructors(e) == 0);
    }


    @Test
    public void checkNumberOfImplementedInterfaces() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.getNumberOfImplementedInterfaces(e) == 0);
        assertTrue(FieldsInitializationCheck.getNumberOfImplementedInterfaces(new HashSet<Integer>()) == 3);
    }

    @Test
    public void checkIfObjectIsSuperclass() throws Exception {
        //given
        ExampleClass e = new ExampleClass();
        //when
        e.initalize();
        //then
        assertTrue(FieldsInitializationCheck.superclassIsObject(e));
        assertFalse(FieldsInitializationCheck.superclassIsObject(new LinkedList<Integer>()));
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
        assertEquals(d.get("Number of array fields"), 1);
    }


}