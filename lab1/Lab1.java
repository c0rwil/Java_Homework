package lab1;
/*----------------------------------------------------
//AUTHOR: CARLOS R. CORRAL-WILLIAMS
//FILENAME: LAB 1
//SPECIFICATION: Finding the average of 3 test scores.
//FOR: CSE 110 - Lab #1
//TIME SPENT: 60 minutes
--------------------------------------------------- */

import java.util.Scanner;

public class Lab1
{
	public static void main(String[] args)
	{
		double testScore1 = 0;
		double testScore2;
		double testScore3;
		final double NUM_TESTS = 3;
		
		Scanner keyboard= new Scanner(System.in);
		
		System.out.println("Plz input your 1st test score: ");
		testScore1 = keyboard.nextDouble();
		System.out.println("Your test 1 score is " + testScore1);
		
		System.out.println("Plz input your 2nd test score: ");
		testScore2 = keyboard.nextDouble();
		System.out.println("Your test 2 score is " + testScore2);
		
		System.out.println("Plz input your 3rd test score: ");
		testScore3 = keyboard.nextDouble();
		System.out.println("Your test 3 score is " + testScore3);
		
		double avg;
		avg = (testScore1 + testScore2 + testScore3) / NUM_TESTS;
		System.out.println("Your average is " + avg);
		}
}