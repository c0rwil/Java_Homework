// Assignment #: 11
// Name: Carlos Corral-Williams
// StudentID: 1222280826
// Description: The Checker class is a utility class that will be used to check if
//              parentheses (), brackets [], and braces {} are matched in a given string.

import java.util.Stack;


public class Checker
{

    public static String check(String inputInfo)
    {
        // new stack obj
        Stack<Character> results = new Stack<>();
        // resulting return string variable
        String resultCheck="";

        // iterate through input using for loop
        for(int index= 0; index<inputInfo.length(); index++)
        {

            // char variable to hold the current char
            char charAtHolder = inputInfo.charAt(index);
            // if starting parenthesis push token 'A'
            if (charAtHolder== '(')
            {
                results.push('A');

            }
            // if closing parenthesis
            else if (charAtHolder==(')'))
            {
                // if size of stack is zero, return error
                if (results.isEmpty()){
                    return ") at the position " + index + " does not match.";
                }
                // else if the resulting pop is NOT token A, return error
                else if (results.pop() != 'A'){
                    return ") at the position " + index + " does not match.";
                }
            }

            // if opening bracket, push token 'B'
            if (charAtHolder== '[')
            {
                results.push('B');

            }

            //if closing bracket
            else if (charAtHolder==(']'))
            {
                // if empty stack
                if (results.isEmpty()){
                    //return the error
                    return "] at the position " + index + " does not match.";
                }
                // if resulting pop isn't 'B', return error
                else if (results.pop() != 'B'){
                    return "] at the position " + index + " does not match.";
                }
            }

            // if opening brace, push token 'C'
            if (charAtHolder== '{')
            {
                results.push('C');

            }
            // if closing brace
            else if (charAtHolder==('}'))
            {
                // if empty, return error
                if (results.isEmpty()){
                    return "} at the position " + index + " does not match.";
                }

                // if resulting pop not token 'C', return error
                else if (results.pop() != 'C'){
                    return "} at the position " + index + " does not match.";
                }
            }
        }



        // if stack is empty, all is matching
        if (results.isEmpty())
        {
            resultCheck = "Everything is matched!";
        }

        // when not empty
        else {
            // store token in char variable 'wrong'
            char wrong = results.pop();

            // then identify the token that is missing a partner, updating resultCheck return statement.
            if(wrong==('A'))
            {
                resultCheck = ") is missing.";
            }
            if(wrong==('B'))
            {
                resultCheck = "] is missing.";
            }
            if(wrong==('C'))
            {
                resultCheck = "} is missing.";
            }
        }
        // then return.
        return(resultCheck);
    }

}



