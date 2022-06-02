// CSE 110     : <Class #15817> / <Fridays 9:05-9:55am>
// Assignment  : <Assignment #05>
// Author      : <Carlos Corral-Williams> & <1222280826>
// Description : <This program performs a variety of string concatenation and math functions, described in detail below.>

public class Assignment05
{
	public static void main(String[] args)
	{
		// Write any code here that you may wish to test your methods defined below.
		
		showGreeting();
		displayMessage("abc" + "123");
		displayTotal(0,1,3,2);
		double sum = getSum(0,1,3);
		System.out.println(sum);
		
		double mean = getMean(0,1,3,2);
		System.out.println(mean);
		
		double totalLength = totalLength("a","abc","ab"); 
		System.out.println(totalLength);
		
		int lengthOfLongest= lengthOfLongest("hello", "goodbye");
		System.out.println(lengthOfLongest);
		
		String stringOfStars = stringOfStars("012345");
		System.out.println(stringOfStars);
		
		String minStringOfStars = minStringOfStars("thursdays", "fridays");
		System.out.println(minStringOfStars);
		
		String minPlusMaxStringOfStars = minPlusMaxStringOfStars("hello", "goodbye","yes");
		System.out.println(minPlusMaxStringOfStars);
		
	}
	
		    
	// 1) Write (define) a public static method named showGreeting, 
    // that takes no arguments and returns no value.
    // When this method is called, it should print the text "Howdy, and welcome!".
	public static void showGreeting()
    {
		System.out.println("Howdy, and welcome!");
	}
		    
		    //2) Write (define) a public static method named displayMessage, 
		    //   that takes a single String argument and returns no value. 
		    //   When this method is called, it should print the value of the argument that was passed to it.
		    public static void displayMessage(String inputString)
		    {
		    	System.out.println(inputString);
		    }
		    
		    //3) Write (define) a public static method named displayTotal, 
		    //   that takes four int arguments. When this method is called, 
		    //   it should print the sum of the three arguments passed to it. 
		    //   This method should return no value.
		    public static void displayTotal(int sumNum1, int sumNum2, int sumNum3, int sumNum4)
		    {
		    	int sum = sumNum1 + sumNum2 + sumNum3 + sumNum4;
		    	System.out.println(sum);
		    }
		    
		    //4) Write (define) a public static method named getSum, 
		    //   that takes three int arguments. When this method is called, 
		    //   it should return the sum of the three arguments passed to it as an int.
		    public static int getSum(int sumNum1, int sumNum2, int sumNum3)
		    {
		    	int sum = sumNum1 + sumNum2 + sumNum3;
		    	return sum;
		    }
		    
		    //5) Write (define) a public static method named getMean, 
		    //   that takes four int arguments. When this method is called, 
		    //   it should return the average of the four arguments passed to it as a double.
		    public static double getMean(int meanNum1, int meanNum2, int meanNum3, int meanNum4)
		    {
		    	double average = (meanNum1 + meanNum2 + meanNum3 + meanNum4) / 4.0;
		    	return average;
		    }
		    
		    //6) Write (define) a public static method named totalLength, 
		    //   that takes three String arguments. When this method is called, 
		    //   it should return the total length (number of characters) 
		    //   of the String arguments passed to it as a double.
		    public static double totalLength(String string1, String string2, String string3)
		    {
		    	double totalLength = string1.length() + string2.length() + string3.length();
		    	return totalLength;
		    }
		    
		    
		    //7) Write (define) a public static method named lengthOfLongest, 
		    //   that takes two String arguments. When this method is called, 
		    //   it should return the length (number of characters) 
		    //   of the longest String argument passed to it as an int.
		    
		    public static int lengthOfLongest(String string1, String string2)
		    {
		    	int string1Size = string1.length();
		    	int string2Size = string2.length();
		    	int lengthOfLongest;
		    	if (string1Size > string2Size)
		    		{
		    		lengthOfLongest = string1Size;
		    		return lengthOfLongest;
		    		}
		    	else 
		    		{
		    		lengthOfLongest = string2Size;
		    		return lengthOfLongest;
		    		}
		    }
		  // 8) Write a public static method named stringOfStars
		  // that takes one String argument. When this method is called
		  // it should return a String of asterisks (*) that is the same length (number
		  // of characters) as the string argument passed to it.
		  // However, if the length of the string argument is less than 3
		  // then the methods should return a string of 3 asterisks,
		  // and if the length of the string argument is greater than 10, 
		  // then the methods should return a string of 10 asterisks
		    
		    public static String stringOfStars(String starString1)
		 // public static String stringOfStars(String starString1)
		    {
		    	String stringOfStars = "";
		    	if (starString1.length() < 3)
		    		{
		    			stringOfStars = "***";
		    		}
		    	else if (starString1.length() > 10)
		    	{
		    			stringOfStars = "**********";
		    	}
		    	else
		    	{
		    		for (var i = 0; i < starString1.length();)
		    		{	
		    			i++;
		    			stringOfStars += "*";
		    		}
		    	}
		    	return stringOfStars;
		    }
		    
		    //9) Write (define) a public static method named minStringOfStars, 
		    //   that takes two String arguments. When this method is called, 
		    //   it should return a String of asterisks (*) 
		    //   that is the same length as the shortest String argument passed to it.
		    public static String minStringOfStars(String minString1, String minString2)
		    {
		    	String minStringOfStars = "";
		    	int minString1Stars = minString1.length();
		    	int minString2Stars = minString2.length();
		    	
		    	if (minString1Stars > minString2Stars)
		    	{
		    		for (var i = 0; i < minString2Stars;)
		    				{
		    				i++;
		    				minStringOfStars += "*";
		    				}
		    	}
		    	
		    	else if (minString2Stars > minString1Stars)
		    	{
		    		for (var i = 0; i < minString1Stars;)
		    			{
		    				i++;
		    				minStringOfStars += "*";
		    			}
		    	}
		    	
		    	else if (minString2Stars == minString1Stars)
		    	{
		    		for (var i = 0; i < minString1Stars;)
		    		{
		    			i++;
		    			minStringOfStars += "*";
		    		}
		    	}
		    	
		    	else 
		    	{
		    		
		    	}
		  
		    		return minStringOfStars;
		    }
		    
		    //10) Write (define) a public static method named minPlusMaxStringOfStars, 
		    //   that takes three String arguments. When this method is called, 
		    //   it should return a String of asterisks (*) 
		    //   that is the same length as the length of the shortest String argument 
		    //   plus the length of the longest String argument.
		    public static String minPlusMaxStringOfStars(String minMaxPlus1, String minMaxPlus2, String minMaxPlus3)
		    {
		    	int minLen = Math.min(minMaxPlus1.length(), Math.min(minMaxPlus2.length(), minMaxPlus3.length()));
		    	int maxLen = Math.max(minMaxPlus1.length(), Math.max(minMaxPlus2.length(), minMaxPlus3.length()));
		    	String minPlusMaxStringOfStars = "";
		    	int totalLengthOfStars = minLen + maxLen;
		    	
		    	for (var i = 0; i < totalLengthOfStars;)
		    	{
		    		i++;
		    		minPlusMaxStringOfStars += "*";
		    	}
		    	return minPlusMaxStringOfStars;
		    	
		    }

	}

