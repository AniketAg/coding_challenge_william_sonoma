package com.codingchallenge.ws;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import com.codingchallenge.ws.zip_code;
public class zip_util 
{
	
	/**
	 * Builds Set of of {@link zip_code} for the given Input String.
	 * 
	 * @param input
	 * @return
	 * @throws zip_exception
	 */
	public zip_set buildzip_set(String input) throws zip_exception
	{
		zip_set zip_set = new zip_set();
		
		//First Lets split the input by space so that we will get Array of of Zip Code Ranges
		List<String> input_zip_rangesList = Arrays.asList(input.split(" "));
		for(String input_zip_range : input_zip_rangesList) 
			zip_set.add(buildZipCodeRange(input_zip_range));
		return zip_set;
	}
	/**
	 * Validates and Builds the {@link zip_code} for the given input string.
	 * @param zipCodeRangeInput
	 * @return
	 * @throws zip_exception
	 */
	private zip_code buildZipCodeRange(String zipCodeRangeInput) throws zip_exception
	{
		zip_code result = null;
		//Check if Each Zip Code Range Start and Ends properly
		if(!(zipCodeRangeInput.startsWith("[") && zipCodeRangeInput.endsWith("]"))) 
			throw new zip_exception(zipCodeRangeInput + " is not a valid input it should start with [ and end with ]");
		
		zipCodeRangeInput = StringUtils.replaceEach(zipCodeRangeInput,new String[] {"[","]"},new String[] {"",""});
		
		result = new zip_code(zipCodeRangeInput);
		return result;
	}
}