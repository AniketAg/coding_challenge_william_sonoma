package com.codingchallenge.ws;

import org.junit.jupiter.api.Test;

public class zip_optimizeTest {

	zip_optimize optimizer = new zip_optimize();
	
	@Test
	public void testzip_codeOptimize() {
		try {
			zip_set zipSet = new zip_set();
			zip_code range1 = new zip_code("95630,99876");
			zip_code range2 = new zip_code("12322,54322");
			zip_code range3 = new zip_code("10876,62321");
			zipSet.add(range1);
			zipSet.add(range2);
			zipSet.add(range3);
			zip_set result = optimizer.optimizezip_set(zipSet);
			assertEquals(2, result.size());	
		}
		catch(Exception ex) 
		{
			fail("Didnt expected any Exception here");
		}
	}

}
