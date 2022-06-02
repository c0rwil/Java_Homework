// Assignment #: 9
//         Name: Carlos Corral-Williams
//    StudentID: 1222280826
//      Lecture: MWF 10:10am-11:00am
//  Description: this program reads in a sequence of numbers from standard
//               input until 0 is read, stores the numbers in an array,
//               then finds the minimum number,
//               the sum of numbers at odd indexes,
//               the sum of positive numbers, and
//               the total count of negative numbers using recursion.

import java.io.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class Assignment9
{

    public static void main(String[] args)
    {
        double sumAtOdd,minimumNum,positiveSum;
        int negativeCount;

        String pattern = "#.00#";
        String patternb2 = "#.0##";
        String patternc3 = "#.#";
        DecimalFormat df = new DecimalFormat(pattern);
        DecimalFormat df2 = new DecimalFormat(patternb2);
        DecimalFormat df3 = new DecimalFormat(patternc3);

        // instantiate the array
        double[] numbers = new double[100];
        // index used for the array of numbers to be read
        int index = 0;
        // where to save one line of input
        String line;

        // Try-Catch block for input stream and buffered reader io exceptions
        try
        {
            //Input Readers
            InputStreamReader inputSR = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputSR);

            // while or do-While loop to store all integers in the array until 0
            // read in the number as a string and parse to an integer and assign
            // it to array element
            do
            {
                numbers[index] = Double.parseDouble(reader.readLine());
                line = String.valueOf(numbers[index]);
                index++;
            }
            while(numbers[index-1]!=0);
            // Continue iterating until 0 is entered

        } // end of try block

        // Catch an IO Exception and print out that it occurs
        catch (IOException ex)
        {
            System.out.println("IO Exception");
        }

        // Call recursive functions findMin, findSumAtOdd, findPositiveSum,
        // findNegative
        minimumNum = findMin(numbers, 0, index-1);
        sumAtOdd = findSumAtOdd(numbers, 0, index-1);
        positiveSum = findPositiveSum(numbers, 0, index-1);
        negativeCount = findNegative(numbers,0, index-1);

        // Print out results in the required format
        System.out.println("The minimum number is " +df.format(minimumNum));
        System.out.println("The sum of numbers at odd indexes is "+df2.format(sumAtOdd));
        System.out.println("The sum of positive numbers is " + df3.format(positiveSum));
        System.out.println("The total count of negative numbers is " + negativeCount);

    } // End main method

    // Recursive static method to find the smallest number in the array
    public static double findMin(double[] numbers, int startIndex, int endIndex)
    {
        // at the termination of the operations, return number at given index
        if(startIndex == endIndex)
        {
            return numbers[endIndex];
        }
        else
        {
            //offset index temp holder for finding minimum between two values
        double tempMin = findMin(numbers, startIndex + 1, endIndex);
            return Math.min(numbers[startIndex], tempMin);
        }
    }
    
    public static double findSumAtOdd(double[] numbers, int startIndex, int endIndex)
    {
        double sumAtOdd;
        //return 0 when reaching the last indexed value
        if (startIndex == endIndex)
        {
            // add 0
            return 0;

        }
        else
        {
            // recursive call
            sumAtOdd = findSumAtOdd(numbers,startIndex,endIndex-1);
            // when index is even do not add to sum
            if(endIndex % 2 == 0)
                return sumAtOdd;
            //when not even, add to sumAtOdd
            else
            return sumAtOdd + numbers[endIndex];
        }
    }

    // Recursive static method to find the sum of positive numbers in the array
    // between the indexes startIndex and endIndex (parameter)
    public static double findPositiveSum(double[] numbers, int startIndex, int endIndex)
    {
        double positiveSum = 0;
        if (startIndex == endIndex)
        {
            // if positive value, add to positiveSum
            if(numbers[endIndex] > 0)
            return  numbers[endIndex];
           
                return 0;

        }
        else
        {
            //recursive call
            positiveSum = findPositiveSum(numbers,startIndex,endIndex-1);
            if (numbers[endIndex] > 0) {
                return findPositiveSum(numbers, startIndex, endIndex - 1) + numbers[endIndex];

            } else {
                return positiveSum;
            }
        }
    }


    // Recursive static method to find how many negative numbers are between the
    // indexes startIndex and endIndex
    public static int findNegative(double[] numbers, int startIndex, int endIndex) {
        // counts the negative nums
        int negativeNums = 0;
        // base case
        if (startIndex == endIndex) {
            return 0;
        }
        // if negative, increment
        else {
            if (numbers[startIndex] < 0) {
                negativeNums = 1;
            }
            //return total
            return negativeNums + findNegative(numbers, startIndex +1, endIndex);
        }
    }
}// End Assignment9 class