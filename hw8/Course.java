// Assignment: #8
// Name: Carlos Corral-Williams
// StudentID: 1222280826
// Lecture: MWF 10:10am - 11:00am
// Description: A serializable class of Course type, holds instructors, courseName, university,
//              a toString + helper methods

import java.io.Serializable;

public class Course implements Serializable
{
    //instance variables
    private String courseName;
    private String university;
    private Instructor instructor;

    //constructor
    public Course(String courseName, String university, Instructor instructor)
    {
        super();
        this.courseName = courseName;
        this.university = university;
        this.instructor = instructor;
    }
    //accessor method
    public String getCourseName()
    {
        return courseName;
    }
    //mutator method
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    //accessor method
    public String getUniversity()
    {
        return university;
    }

    //accessor method
    public void setUniversity(String university)
    {
        this.university = university;
    }
    //accessor method
    public Instructor getInstructor()
    {
        return instructor;
    }
    //mutator method
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }
    //returns a string that represents a Course object
    public String toString()
    {
        return "\nCourseName:\t\t" + courseName + "\n" + "University:\t\t" + university + "\n" + "Instructor:\t\t"
                + instructor.toString() + "\n";
    }

}
