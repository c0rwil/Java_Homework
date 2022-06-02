package lab1;

import java.util.Scanner;
/*-------------------------------------------------------------
// AUTHOR: Carlos Corral-Williams
// FILENAME: Lab3
// SPECIFICATION: This is a program which will compute the average of 3 grade inputs in order to calculate the weighted total of them (based on a formula).
// FOR: CSE 110-Lab #3 (Friday 9:05am - 9:55am)
// TIME SPENT: 75 minutes
//-----------------------------------------------------------*/

public class Lab3
{

	public static void main(String[] args)
	{
		/* declaring Scanner class object. */
		Scanner keyboard = new Scanner(System.in);
		/* declaring variables */
		double examFinal = 0, examMidterm = 0, homework = 0;
		int i = 0;
		int numChances =3;
		
		/* prompts user for inputs used in calculations */
		while (i<3 && numChances >=0)
		{
			if (i == 0)
			{
				System.out.print("Enter your HOMEWORK grade: ");
				if (numChances < 3)
				{
					System.out.print("(" + numChances + " chances reamining): ");
				}
				
				homework = keyboard.nextDouble();
				if (homework >= 0 && homework <= 100)
				{
					i++;
					numChances = 3;
				}
				
				else
				{
					System.out.println("[ERR] Invalid input. A homework grade should be in [0,100]");
					numChances--;
				}
			}
			
			else if (i == 1)
			{
				System.out.print("Enter your MIDTERM EXAM grade: ");
				examMidterm = keyboard.nextDouble();
			
				if (examMidterm >= 0 && examMidterm <=100)
				{
					i++;
					numChances = 3;
				}
				
				else
				{
					System.out.println("[ERR] Invalid input. A midterm grade should be in [0,100]");
					numChances--;
				}
			}
			
			else if (i == 2)
			{
				System.out.print("Enter your FINAL EXAM grade :");		
				examFinal = keyboard.nextDouble();
				
				if (examFinal >= 0 && examFinal <= 200)
				{ 
					i++;
					numChances = 3;
				}
				else
				{
					System.out.println("[ERR] Invalid input. An exam final grade should be in [0,200]");
					numChances--;
				}
			}
		}
		
		if (numChances < 0)
		{
			System.out.println("[ERR] You have retried 3 times. Please restart your program.");
		}
		
		else
		{
			double totalWeighted = (examFinal / 200 * 50) + (examMidterm * 0.25) + (homework * 0.25);
			System.out.println("[INFO] Student's Weighted Total is: " + totalWeighted);
	
			if (totalWeighted >=50) 
			{
				System.out.println("[INFO] Student PASSED the class.");
			}
		
			else
			{
			System.out.println("[INFO] Student FAILED the class.");
			}
		}
	}

}
