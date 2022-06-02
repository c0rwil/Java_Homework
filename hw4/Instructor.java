// Assignment #: 4
//         Name: Carlos R. Corral-Williams
//    StudentID: 1222280826
//      Lecture: 10:10 AM - 11:00 AM
//  Description: This class defines a brand new datatype of the name "Instructor" and what follows is the standard
//               instance variables for the class, as well as getters/setters, and a toString method.
//  Average time spent: 1 hr

public class Instructor
{
    // instance variables
    private String firstName;
    private String lastName;
    private String officeNum;

    // Instructor default constructor
    public Instructor()
    {
        this.firstName = "?";
        this.lastName = "?";
        this.officeNum = "?";
    }

    // Instructor modified constructor
    public Instructor(String first, String last, String officeNum)
    {
        this.firstName = first;
        this.lastName = last;
        this.officeNum = officeNum;
    }
    // a method that takes an Instructor object, and deconstructs it into its' instance variables using getterMethods,
    // storing them in local variables, before constructing a brand new Instructor class using the implicit variables of
    // the passed instructor
    public Instructor(Instructor inceptionInstructor)
    {
        this.firstName = inceptionInstructor.getFirstName();
        this.lastName = inceptionInstructor.getLastName();
        this.officeNum = inceptionInstructor.getOfficeNum();
    }

    // getter for Instructor's first name
    public String getFirstName()
    {
        return firstName;
    }

    // getter for Instructor's last name
    public String getLastName()
    {
        return lastName;
    }

    // getter for Office Number
    public String getOfficeNum()
    {
        return officeNum;
    }

    // setter for Instructor's first name
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // setter for Instructor's last name
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // setter for Office number
    public void setOfficeNum(String officeNum)
    {
        this.officeNum = officeNum;
    }

    // toString method for converting Instructor objects into strings
    public String toString()
    {
        return "\nLast Name:\t" +lastName + "\nFirst Name:\t" + firstName + "\nOffice Number:\t" + officeNum + "\n";
    }
}
