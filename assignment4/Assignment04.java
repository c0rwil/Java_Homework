// CSE 110     : <Class #15817> / <Fridays 9:05-9:55am>
// Assignment  : <Assignment #04>
// Author      : <Carlos Corral-Williams> & <1222280826>
// Description : <This is a number guessing game, the User guesses a randomly generated 3 digit number in as many guess as it takes. Hints provided>

import java.util.Scanner;
import java.lang.Math;

public class Assignment04 {
// Master Mind Game: User attempts to guess the correct 3 digit number in as many tries as possible. Hints and replay features included.
	public static void main(String[] args) {
		// initiate Scanner and replay boolean
		Scanner keyboard = new Scanner(System.in);
		boolean replay = true; 
		
		// Setting up the replay feature through use of a while loop.
		while (replay)
		{
		// initializing the range of numbers for random number generator, initializing guessCounter and matches, other relevant variables.
		int minimum = 100; 
		int maximum = 999;
		int guess;
		int guessCount = 1;
		int secretNumber = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
		String secretString = Integer.toString(secretNumber); // converting to string to be able to compare input and secret number.
		int matches = 0;
		
		System.out.println("----- MASTERMIND -----");
		System.out.println("Guess the 3 digit number!");
		System.out.print("Guess 1: ");
		guess = keyboard.nextInt();
		guessCount++;
		String input = Integer.toString(guess);
		replay = true;
		char[] secretStringArr = secretString.toCharArray(); // converting my casted variables to arrays
		char[] inputArr = input.toCharArray();
		
		// comparing the input and output
		
		int minLength = Math.min(secretStringArr.length, inputArr.length);
		for ( int i = 0; i < minLength; i++)
		{
			if (secretStringArr[i] == inputArr[i])
			{
				matches++;
			}
		}
		System.out.println("You matched " + matches);
		
		// setting up the while loop for the game
		while (guess > secretNumber || guess < secretNumber && replay == true) 
		{
			matches = 0; // resetting match count after initial guess
			System.out.print("Guess " + guessCount + ": ");
			guess = keyboard.nextInt();
			input = Integer.toString(guess);
			inputArr = input.toCharArray();
			guessCount++;
			minLength = Math.min(secretStringArr.length, inputArr.length);
			
			for ( int i = 0; i < minLength; i++)
			{
				if (secretStringArr[i] == inputArr[i])
				{
					matches++;
				}
			}
			System.out.println("You matched " + matches);
		}
		
		// setting up the win event
		if (guess == secretNumber)
		{
			System.out.println("Congratulations! You guessed the right number in " + (guessCount - 1) + " guesses.");
			System.out.println("Would you like to play again (yes/no)?");
			String reply = keyboard.next();
			if (reply.equals("Yes") || reply.equals("yes"))
			{
				replay = true;
			}
			else if (reply.equals("No") || reply.equals("no"))
			{
				replay = false;
			}
			else
			{
				replay = false;
			}
		}
		}
	}

	
}	
