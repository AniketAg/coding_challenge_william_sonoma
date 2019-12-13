package com.codingchallenge.ws;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.*;
/**
 * Unit test for simple App.
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class AppTest extends App 
{
    
    @Test
    public void testCase1() 
    {
		String input = "[94133,94133] [94200,94299] [94226,94399]";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		App.main(null);
	}

	@Test
	public void testCase2() {
		String input = "[94133,94133] [94100,94109] [94226,94399]";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		App.main(null);
	}

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
