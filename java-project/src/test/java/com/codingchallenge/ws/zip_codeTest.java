package com.codingchallenge.ws;

import junit.*;
import org.junit.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class zip_codeTest {

	@Test
	public void testInvalidzip_code_StartShouldBeSmallerThanEnd() {
		try {
			new zip_code("18234,12345");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}

	}

	@Test
	public void testInvalidzip_code_BothStartAndEndShouldBeNumeric() {
		try {
			new zip_code("12345,12ss2");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}

	}

	@Test
	public void testInvalidzip_code_InvalidLength() {
		try {
			new zip_code("1112345,11220");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}
	}

	@Test
	public void testInvalidzip_code_MMorethanOneParameter() {
		try {
			new zip_code("12345,11220,1223");
			fail("Expected an Eception");
		} catch (Exception ex) {

		}

	}

	@Test
	public void testZipCodeSet() throws Exception {
		zip_code range1 = new zip_code(95630, 95890);
		zip_code range2 = new zip_code(14525, 12565);
		zip_code range3 = new zip_code(12345, 98658);
		zip_code range4 = new zip_code(12345, 98658);
		zip_code range5 = new zip_code("12345,98658");
		
		zip_set inputHolder = new zip_set();
		inputHolder.add(range1);
		inputHolder.add(range2);
		inputHolder.add(range3);
		inputHolder.add(range4);
		inputHolder.add(range5);
		assertFalse(range1.equals(range2));
		assertTrue(range4.equals(range5));
		assertNotNull(range1.hashCode());
		for (zip_code range : inputHolder) {
			System.out.println(range);
		}
	}

}
