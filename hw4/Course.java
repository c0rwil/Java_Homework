// Assignment #: 4
//         Name: Carlos R. Corral-Williams
//    StudentID: 1222280826
//      Lecture: 10:10 AM - 11:00 AM
//  Description: This class defines a brand new datatype of the name "Course" and what follows is the standard
//               instance variables for the class, as well as getters/setters, and a toString method.
//  Average time spent: 1 hr

public class Course
{
    // instance variables
    private String courseName;
    private Instructor myInstructor;
    private String university;

    // default constructor
    public Course()
    {
        this.courseName = "?";
        this.myInstructor = new Instructor();
        this.university = "?";
    }

    // modified constructor
    public Course(String inputName, Instructor myInstructor, String university)
    {
        this.courseName = inputName;
        this.myInstructor = myInstructor;
        this.university = university;
    }

    // getter for Name variable
    public String getName()
    {
        return courseName;
    }

    // getter for university name
    public String getUniversity()
    {
        return university;
    }

    // getter for Instructor
    public Instructor getInstructor()
    {
        return myInstructor;
    }

    // setter for course name
    public void setName(String courseName)
    {
        this.courseName = courseName;
    }

    // setter for university name
    public void setUniversity(String university)
    {
        this.university = university;
    }

    // toString method for converting Course objects into a string
    public String toString()
    {
        return "Course name:\t" + courseName + " at " + university + "\nInstructor Information:" + myInstructor;
    }
}
