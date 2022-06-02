// Assignment: #8
// Name: Carlos Corral-Williams
// StudentID: 1222280826
// Lecture: MWF 10:10am - 11:00am
// Description: This class is a utility class that will be used by Course objects on varying criteria.

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts
{
    public static void sort(ArrayList<Course> courseList, Comparator<Course> xComparator)
    {
        //write your code here
        int min;
        for(int index = 0; index < courseList.size(); index++)
        {
            min = index;
            for(int scan = index+1; scan < courseList.size(); scan++ )
            {
                if( xComparator.compare(courseList.get(scan), courseList.get(min))< 0)
                    min = scan;
            }
            swap(courseList,min,index);
        }


    }
    private static void swap (ArrayList<Course> data, int index1, int index2)
    {
        Course temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2,temp);
    }
} 
