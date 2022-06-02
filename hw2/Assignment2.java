// Assignment #: 2
//         Name: Carlos R. Corral-Williams
//    StudentID: 1222280826
//      Lecture: 10:10 AM - 11:00 AM
//  Description: This class reads an unspecified number of integers from standard input, performs some calculations on
//               the inputted numbers, and outputs the result of those calculations to standard output.
//  Average time spent: 5 hours

// for scanner class
import java.util.*;

public class Assignment2
{
    public static void main(String[] args)
    {
        // instantiating scanner
        Scanner scan = new Scanner(System.in);
        // variables we are tracking from each run in the while loop
        int negativeCount = 0;
        int minimum = 0;
        int largestOdd= 0;
        int evenSum = 0;
        int temp = 1;

        // a counter variable for counting the # of times
        // the while loop has passed
        int count = 0;
        // parses through while loop as long as there are more integers to be read
        while (temp!=0)
        {
            // instantiating temporary variable to hold the current variable being passed through before
            temp = scan.nextInt();
            // in the case that userInput is 0
            if (temp!=0)
            {
                // In the case that temp is less than 0, increment negativeCount
                if (temp < 0)
                {
                    negativeCount++;
                }
                // If temp is less than the current minimum or the count is 0, replace minimum value and increment count
                if (temp < minimum || count == 0)
                {
                    minimum = temp;
                    count++;
                }
                // if input is odd AND input is greater than currently stored value for largestOdd, update.
                if (temp % 2 != 0 && temp > largestOdd)
                {
                    largestOdd = temp;
                }
                // if read input is even value, add with current value storing the sum of even ints read so far.
                if (temp % 2 == 0)
                {
                    evenSum = evenSum + temp;
                }
            }
        }

        System.out.print("The minimum integer is " + minimum + "\n"
                + "The largest odd integer in the sequence is " + largestOdd + "\n"
                + "The count of negative integers in the sequence is " + negativeCount + "\n"
                + "The sum of even integers is " + evenSum + "\n");
        }
    }


