import org.junit.Test;

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
}