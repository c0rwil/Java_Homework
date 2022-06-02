// Assignment: #8
// Name: Carlos Corral-Williams
// StudentID: 1222280826
// Lecture: MWF 10:10am - 11:00am
// Description: This class implements a comparator and returns a value of <0 if the first of 2 objects(courseNames)
//              being compared comes alphabetically before the second, 0 if they are the same,
//              and >0 if it should be placed after.
import java.util.Comparator;
public class CourseNameComparator implements Comparator<Course>
{
    public int compare(Course first, Course second)
    {
        String course1 = first.getCourseName();
        String course2 = second.getCourseName();
        return course1.compareTo(course2);
    }
}
