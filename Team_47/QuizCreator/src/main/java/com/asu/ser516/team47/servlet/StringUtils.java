package edu.au.quiz.utils;

/**
 * @author Amit Pandey
 * Utility Method
 */
public class StringUtils 
{
	public static boolean isNullOREmpty(String name)
	{
		return (name == null || name.trim().length() == 0);
	}//isNullOrEmpty
	
	public static boolean areNullOrEmpty (String... names)
	{
		boolean isNull = false;
		for (String name : names)
		{
			isNull = isNullOREmpty(name);
		}//for
		return isNull;
	}//areNullOrEmpty
	
}//StringUtils