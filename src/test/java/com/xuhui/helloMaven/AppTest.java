package com.xuhui.helloMaven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        Integer i1 = 128, i2 = 128;
        assertEquals(i1, i2);
        assertFalse(i1 == i2);
    }

    @Test
    public void testApp2()
    {
        Integer i1 = 127, i2 = 127;
        assertEquals(i1, i2);
        assertTrue(i1 == i2);
    }

    @Test
    public void testApp3()
    {
        Integer i1 = -128, i2 = -128;
        assertEquals(i1, i2);
        assertTrue(i1 == i2);
    }

    @Test
    public void testApp4()
    {
        Integer i1 = -129, i2 = -129;
        assertEquals(i1, i2);
        assertFalse(i1 == i2);
    }

}
