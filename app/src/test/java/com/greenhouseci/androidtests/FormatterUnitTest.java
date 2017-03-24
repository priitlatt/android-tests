package com.greenhouseci.androidtests;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FormatterUnitTest {

    private Formatter formatter = new Formatter();

    @Test
    public void checkStripLeft() throws Exception {
        String original = "   \t\n    string   ";
        String formattedString = formatter.stripLeft(original);
        String expected = "string   ";
        assertEquals(expected, formattedString);
    }

    @Test
    public void checkStripRight() throws Exception {
        String original = "   string   \t\n    ";
        String formattedString = formatter.stripRight(original);
        String expected = "   string";
        assertEquals(expected, formattedString);
    }

    @Test
    public void checkStripMiddle() throws Exception {
        String original = " string1   \t\n    string2 ";
        String formattedString = formatter.stripMiddle(original);
        String expected = " string1 string2 ";
        assertEquals(expected, formattedString);
    }
}
