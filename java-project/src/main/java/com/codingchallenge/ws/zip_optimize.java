package com.codingchallenge.ws;

import java.util.*;

import com.codingchallenge.ws.zip_code;

class zip_set extends TreeSet<zip_code> 
{
	private static final long serialVersionUID = 1L;	
}

/**
 * An Utility class to optimize the set of Zip Code Ranges and Optimizes to 
 * minimum number of zip code ranges same as input.
 * 
 * @author aniket
 *
 */
public class zip_optimize 
{

	/**
	 * Optimizes the and produces the minimum number of zip code ranges required to 
	 * represent the same restrictions as the given input.
	 * 
	 * @param input_zip_set
	 * @return
	 */
	public zip_set optimizezip_set(zip_set input_zip_set) 
	{
		zip_set optimized_zipSet = new zip_set(); 
		Iterator<zip_code> zip_iterator = input_zip_set.iterator();
		while(zip_iterator.hasNext()) 
		{
			zip_code new_range =zip_iterator.next();

			if(optimized_zipSet.size() > 0) 
			{
				zip_code range = checkRange(new_range,optimized_zipSet.last());
				if(range != null) 
				{
					if(!range.new_range()) 	optimized_zipSet.pollLast();
					optimized_zipSet.add(range);
				}
			}
			else 	//Lets add the first Element
				optimized_zipSet.add(new_range);			
		}
		return optimized_zipSet;
	}

	/**
	 * 
	 * @param new_range
	 * @param oldRange
	 * @return
	 */
	private zip_code checkRange(zip_code new_range, zip_code oldRange) 
	{
		zip_code range = null;
		if(oldRange.get_upper_bound_zip() > new_range.get_upper_bound_zip()) 	return range;
		if(oldRange.get_upper_bound_zip() < new_range.get_lower_bound_zip()) 
		{
			new_range.set_new_range(true);
			return new_range;
		}
		
		if(oldRange.get_upper_bound_zip() > new_range.get_lower_bound_zip()) 
		{
			oldRange.set_upper_bound_zip(new_range.get_upper_bound_zip());
			oldRange.set_new_range(false);
		}
		
		if(oldRange.get_upper_bound_zip() < new_range.get_lower_bound_zip()) 
		{
			new_range.set_new_range(true);
			return new_range;
		}
		return range;
	}
}