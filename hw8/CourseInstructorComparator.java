// Assignment: #8
// Name: Carlos Corral-Williams
// StudentID: 1222280826
// Lecture: MWF 10:10am - 11:00am
// Description:This class implements a comparator and returns a value of <0 if the first of 2 objects being compared
//              comes alphabetically before the second, 0 if they are the same, and >0 if it should be placed after.

import java.util.Comparator;

public class CourseInstructorComparator implements Comparator<Course>
{   // complete the code. If the first argument object has its instructor's last name less than that of
    // the second argument, an integer less than zero is returned; if the first argument object has its 
    // instructor's last name larger than that of the second argument, an int greater than zero is returned.
    public int compare(Course first, Course second)
    {
        // retrieving instructor's names
        String fName = first.getInstructor().getLastName();
        String fName2 = second.getInstructor().getLastName();

        // returning the result of the comparison
        int sum = fName.compareTo(fName2);
        return sum;
    }
}
