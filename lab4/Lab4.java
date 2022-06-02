/*-------------------------------------------------------------
// AUTHOR: Carlos Corral-Williams
// FILENAME: Lab4
// SPECIFICATION: This is a program which will display a menu that will call various methods.
// FOR: CSE 110-Lab #4 (Friday 9:05am - 9:55am)
// TIME SPENT: 75 minutes
//-----------------------------------------------------------*/
import java.util.Scanner;

public class Lab4 
{

	public static void main(String[] args) 
	{
		// Declare some variables you need
		int choice = 0;
		int sumTo = 0;
		int factorialTo = 0;
		int leftMostDigit = 0;
		Scanner keyboard = new Scanner(System.in);
		
		do 
		{
			// Display the menu
			displayMenu();
			
			// ask the user for one option
			choice = keyboard.nextInt();
			
			switch (choice)
			{
			// Define four cases for different options. don't forget 'break'
			case 1:
				System.out.print("Enter a number: ");
				sumTo = keyboard.nextInt();
				int sum = 0;
				
				for (int i = 1; i <= sumTo ;i++ )
				{
					sum += i;
				}
				System.out.println("The sum of 1 to " + sumTo + " is " + sum);
				break;
			case 2:
				System.out.println("Enter a number: ");
				factorialTo = keyboard.nextInt();
				int factorial = 1;
				for (int i = 1; i <= factorialTo; i++)
				{
					factorial *= i;
				}
				System.out.println("The factorial of " + factorialTo + " is " + factorial);
				break;
				
			case 3: 
				System.out.print("Enter a number: ");
				leftMostDigit = keyboard.nextInt();
				int left = leftMostDigit;
				
				while(left >= 10)
				{ 
					left /= 10;
				}
				System.out.println("The leftmost digit of " + leftMostDigit + " is " + left);
				break;
			case 4:
				System.out.println("Bye");
				break;
			} 
		} while(choice !=4); }
		
		/** 
		 * Print the menu
		*/
		
		private static void displayMenu () 
		{
			System.out.println("Please choose one option from the following menu:");
			System.out.println("1) Calculate the sum of integers from 1 to m");
			System.out.println("2) Calculate the factorial of a given number");
			System.out.println("3) Display the leftmost digit of a given number");
			System.out.println("4) Quit");
	
		
	}
}
