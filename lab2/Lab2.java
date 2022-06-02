package lab1;

import java.util.Scanner;
/*---------------------------------------------------------------
// AUTHOR: <Carlos Corral-Williams>
// FILENAME: Lab2.java
// SPECIFICATION: <This program will prompt the user for their first and last name, and print their name's length>
// FOR: CSE 110 - Lab 2 F9:05
// TIME SPENT: <60 mins>
//--------------------------------------------------------------- */ 

public class Lab2 
{
	public static void main(String[]args)
	{
		/* declaring Scanner class object */
		Scanner keyboard = new Scanner(System.in);
		/* declaring string and int variables */ 
		String firstName, lastName, fullName = "";
		int nameLength;
		
		System.out.println("Please enter first name: ");
		firstName = keyboard.nextLine();
		System.out.println("Please enter your last name: ");
		lastName = keyboard.nextLine();
		fullName = firstName + " " + lastName;
		fullName = fullName.toUpperCase();
		nameLength = fullName.length();
		System.out.println("Full name (in capitals):" + fullName);
		System.out.println("Length of full name:" + nameLength);
		String fullName1 = new String(fullName);
		if (fullName1 == fullName) 
		{
			System.out.println("String comparison using \" == \" sign does NOT work");
		}
		
		else
		{
			System.out.println("String comparison using \" == \" sign does NOT work");
		}
		
		if (fullName1.equals(fullName))
		{
			System.out.println("String comparison using \"equals\" method does work");
		}
		else 
		{
			System.out.println("String comparison using \"equals\" method does work");
		}
	}
}
