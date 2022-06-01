// Assignment #: 1
//         Name: Carlos R. Corral-Williams
//    StudentID: 1222280826
//      Lecture: 10:10 AM - 11:00 AM
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.
//  Average Time Spent: 1 hour

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory

public class Assignment1
{

    public static void main (String[] args)
    {
        // for reading user inputs
        Scanner console = new Scanner(System.in);
        // for tracking the number entered
        int number;
        // scans the next int value entered
        number = console.nextInt();


        // display the number with other messages
        System.out.print("This program reads an integer from a keyboard\n"
                + "and prints it out on the display screen.\n"
                + "Make sure that you get the exact same output as the expected one.\n"
                + "The read number is: " + number + "\n");
    }
}


