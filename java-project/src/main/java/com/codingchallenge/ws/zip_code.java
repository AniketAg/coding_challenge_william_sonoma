package com.codingchallenge.ws;

import java.text.DecimalFormat;

/**
 * 
 * @author aniket
 * 
 * Domain class to hold the set of Zip Code Range Information.
 *
 */
class zip_exception extends Exception 
{
	private static final long serialVersionUID = 1L;
	public zip_exception(String message) 
	{
		super(message);
	}	
}

public class zip_code implements Comparable<zip_code>
{
	private String zip_range;
	private int start;
	private int end;
	private boolean new_range = true;;

	public zip_code(int start_zip, int end_zip) 
	{
		set_lower_bound_zip(start_zip);
		set_upper_bound_zip(end_zip);
		set_zip_range("["+start_zip+","+end_zip+"]");
	}

	public zip_code(String input) throws zip_exception
	{
		String[] range = input.split(",");
		if(range.length  != 2) 
		{
			throw new zip_exception("["+input+"] is not a valid input it should contain exactly 2 parts upper and lower bound zip codes separated with comma");
		}
		
		if(range[0].length() != 5 || range[1].length() != 5) 
		{
			throw new zip_exception("["+input + "] is Not Valid Input, both zip code length should be 5 digits");
		}
		try 
		{
			this.start = Integer.parseInt(range[0]);
			this.end = Integer.parseInt(range[1]);
		}
		catch (Exception e) 
		{
			throw new zip_exception("["+input + "] is Not Valid Input, both zip codes should be numeric.");
		}
		
		if(start > end) 
		{
			throw new zip_exception("["+input + "] is Not  Valid Input, Start Zip Code should be smaller than End Zip Code.");
		}
		
		this.zip_range = "["+start+","+end+"]";		
	}

	/**
	 * @return the zip_range
	 */
	public String get_zip_range() 
	{
		return zip_range;
	}

	/**
	 * @param zip_range the zip_range to set
	 */
	public void set_zip_range(String zip_range) 
	{
		this.zip_range = zip_range;
	}

	/**
	 * @return the start_zip
	 */
	public int get_lower_bound_zip() 
	{
		return start;
	}

	/**
	 * @param start_zip the start_zip to set
	 */
	public void set_lower_bound_zip(int start_zip) 
	{
		this.start = start_zip;
	}

	/**
	 * @return the end_zip
	 */
	public int get_upper_bound_zip() 
	{
		return end;
	}

	/**
	 * @param end_zip the end_zip to set
	 */
	public void set_upper_bound_zip(int end_zip) 
	{
		this.end = end_zip;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		result = prime * result + ((zip_range == null) ? 0 : zip_range.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)	return true;
		if (obj == null)	return false;
		if (getClass() != obj.getClass())	return false;
		zip_code other = (zip_code) obj;
		if (end != other.end) return false;
		if (start != other.start) return false;
		if (zip_range == null) 
		{
			if (other.zip_range != null) return false;
		} 
		else if (!zip_range.equals(other.zip_range)) return false;
		return true;
	}

	@Override
	public String toString() 
	{
		DecimalFormat format = new DecimalFormat("00000");
		return "[" + format.format(start) +","+format.format(end)+"]";
	}

	public int compareTo(zip_code zip_range) 
	{
		return start-zip_range.get_lower_bound_zip();
	}

	/**
	 * @return the new_range
	 */
	public boolean new_range() 
	{
		return new_range;
	}

	/**
	 * @param new_range the new_range to set
	 */
	public void set_new_range(boolean new_range) 
	{
		this.new_range = new_range;
	}
}
