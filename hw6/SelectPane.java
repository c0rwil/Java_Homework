//  Assignment #: 6
//  Arizona State University - CSE205
//  Name: Carlos R. Corral-Williams
//  StudentID: 1222280826
//  Lecture Date and Time: MWF 10:10am-11:00am
//  Description: SelectPane displays a list of available courses
//  from which a user can select and compute total number of students in multiple courses.

//import java.awt.*;
import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

/**
* SelectPane displays a list of available courses from which a user
* can select and compute total number of students for selected courses.
*/
public class SelectPane extends BorderPane {

    //declare instance variables
    private ArrayList<Course> courseList;
    private int numOfStudents;

    private Label descriptionNum,description;
    private CheckBox checko;
    private VBox checkBoxCont;

    public SelectPane(ArrayList<Course> list) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */

        description = new Label("Select Course(s)");
        descriptionNum = new Label("Total Number of Students for the selected course(s):\t"+ numOfStudents);
        numOfStudents = 0;
        this.courseList = list;
        checkBoxCont = new VBox();
        checkBoxCont.setSpacing(1);

        // Wrap checkboxContainer in ScrollPane so formatting is
        // correct when many courses are added
        ScrollPane scroll = new ScrollPane();
       // scroll = new ScrollPane(checkBoxCont);
        scroll.setContent(checkBoxCont);
        // Setup layout
        this.setTop(description);
        this.setBottom(descriptionNum);
        this.setCenter(scroll);

        //create an empty pane where you can add check boxes later
        //SelectPane is a BorderPane - add the components here


    } // end of SelectPane constructor

    // This method uses the newly added parameter Course object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateCourseList(Course newCourse)
    {
        // Create checkbox for new course with appropriate text
        CheckBox checko = new CheckBox(newCourse.toString());
        // Bind checkbox toggle action to event handler
        checko.setOnAction(new SelectionHandler(newCourse.getNumStudents()));
        // Passes the number of students in each course to the handler. When the checkbox is
        // toggled, this number will be added/subtracted from the total number of selected students


        // Add new checkbox to checkbox container

        checkBoxCont.getChildren().add(checko);

    } // end of updateCourseList method

    /**
     * SelectionHandler This class handles a checkbox toggle event. When the
     * checkbox is toggled, this number will be added/subtracted from the total
     * number of selected students.
     */
    private class SelectionHandler implements EventHandler<ActionEvent> {
        // Instance variable for number of students associated with a given course/checkbox
        private int numStudents;


        public SelectionHandler(int nums) {
            this.numStudents = nums; // Set instance variable
        } // end of SelectionHandler constructor

        //over-ride the abstract method handle
        public void handle(ActionEvent event) {
            // Get the object that triggered the event, and cast it to a checkbox, since
            // only a course checkbox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method

                CheckBox chkBox = (CheckBox) event.getSource();


            // Update the label with the new number of selected students
            if (chkBox.isSelected())
            {
                numOfStudents += numStudents;
            }
            else
                {
                numOfStudents -= numStudents;
                }
            descriptionNum.setText("Total number of students for the selected course(s): " + numOfStudents);

                } // end handle method
    } // end of SelectHandler class
} // end of SelectPane class
