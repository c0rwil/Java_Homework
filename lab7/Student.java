/*-------------------------------------------------------------
 * // AUTHOR: Carlos Corral-Williams
 * // FILENAME: AutoGrader.java
 * // For: CSE 110-Lab #7 (Friday 9:05am - 9:55am)
 * // SPECIFICATION: This is your test driver for Lab7. 
 * // Please do NOT touch anything in this file.
 * -----------------------------------------------------------*/

public class Student 
{
	private String fullName, asuID;
	private double grade;
	private int numOfUpdates, numOfAccessed;
	
	private String studentName;
	// default constructor
	public Student()
	{
		this.asuID = null;
		this.fullName = null;
        this.grade = -1;  // an impossible value to say it's N/A
        this.numOfUpdates = 0;
        this.numOfAccessed = 0;
	}
    //overloaded constructor
    public Student(String fullName, String asuID, double grade) 
    {
    	this.asuID = asuID;
    	this.grade = grade;
    	this.fullName = fullName;
    	this.numOfUpdates = 0;
    	this.numOfAccessed = 0;
    }
    public boolean equals(Student other)
    {
    	// Check whether two objects have available asuID
    	if (this.asuID != null && other.asuID != null) 
    	{
    		if (this.asuID.equals(other.asuID)) 
    		{
    			return true;
    		}
    	}
    	else if (this.fullName != null && other.fullName != null)
    	{
    		
    	}
    	return false;
    }
    // return student's info
    public String toString()
    {
    	return String.format("[Name: %s, ASUID: %s, Grade: %.2f]", fullName, asuID,grade);
    }
    
    // mutator method
    public void setName(String fullName)
    {
    	this.fullName = fullName;
    }
    // mutator methods 
    public void setId(String id)
    {
    	this.asuID= id;
    }
    
    public void setGrade(double grade)
    {
    	this.grade = grade; 
    }
    
    // accessor methods
    public String getFullname() 
    {
    	return fullName;
    }
    
    public String getAsuID()
    {        
    	return asuID;
    }
    public double getGrade() 
    {        
    	return grade;
    }
    public int getNumOfUpdates() 
    {        
    	return numOfUpdates;
    }
    public int getNumOfAccessed() 
    {        
    	return numOfAccessed;    
    }
}