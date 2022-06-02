// Assignment 6: ASU - CSE 205
//  Name: Carlos R. Corral-Williams
//  StudentID: 1222280826
//  Lecture Date and Time: MWF 10:10am-11:00am
//  Description: GeneratePane creates a pane where a user can enter
//  course information and create a list of available courses.
//  Time Spent : 15 hr

/* --------------- */
/* Import Packages */
/* --------------- */

import java.text.NumberFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// JavaFX classes
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a course
 * information and create a list of available courses.
 */
public class GeneratePane extends HBox {
    /* ------------------ */
    /* Instance variables */
    /* ------------------ */
    //declare and init
    private ArrayList<Course> courseList;
    private SelectPane selectPane; // The relationship between GeneratePane and SelectPane is Aggregation

    Button button1;
    Label errorLabel;
    Label courseName, instructorName, universityName, studentCount;
    TextField courseField, instructorField,universityField,studentField;
    TextArea textArea;

    /**
     * CreatePane constructor
     *
     * @param list   the list of courses
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Course> list, SelectPane sePane) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */
        this.courseList = list;
        this.selectPane = sePane;

        //initialize each instance variable (textfields, labels, textarea, button, etc.)
		//and set up the layout
         button1 = new Button("Add a course");
         courseName = new Label("Course Name");
         instructorName = new Label("Name of Instructor");
         universityName = new Label("Name of University");
         studentCount = new Label("Number of Students");
         errorLabel = new Label("");

         courseField = new TextField();
         instructorField = new TextField();
         universityField = new TextField();
         studentField = new TextField();

         textArea = new TextArea("No Courses");
         textArea .setEditable(false);

        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(10,10,10,10));
		//create a GridPane to hold labels & text fields.
		//you can choose to use .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);

		// Set both left and right columns to 50% width (half of window)
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);

        gridPane.add(courseName,0,1);
        gridPane.add(courseField,1,1);
        gridPane.add(instructorName,0,2);
        gridPane.add(instructorField,1,2);
        gridPane.add(universityName,0,3);
        gridPane.add(universityField,1,3);
        gridPane.add(studentCount,  0,4);
        gridPane.add(studentField,1,4);
        gridPane.add(button1,1,5,4,5);
        gridPane.add(errorLabel,0,0);

        vBox1.getChildren().addAll(gridPane);

        vBox2.getChildren().add(textArea);
		//Set up the layout for the left half of the GeneratePane.

		//the right half of the GeneratePane is simply a TextArea object
		//Note: a ScrollPane will be added to it automatically when there are no more space
		//Add the left half and right half to the GeneratePane
        this.getChildren().add(vBox1);
        this.getChildren().add(vBox2);

		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
        button1.setOnAction(new ButtonHandler());


    } // end of constructor

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a course" is pushed
     * or not, When the event occurs, it asks for course and instructor name, number of students enrolled,
     * and its university information from the relevant text fields, then create a
     * new course and adds it to the courseList. Meanwhile it will display the course's
     * information inside the text area. using the toString method of the Course
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of student
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        /*
         * handle Override the abstract method handle()
         */

        public void handle(ActionEvent event)
        {
            // Declare local variables
            boolean isEmptyFields;
            Course newCours;
            int numberOfStudents = 0;
            String courseName = courseField.getText();
            String instructorName = instructorField.getText();
            String universityName = universityField.getText();
            String studentCount = studentField.getText();
            Course duplicateChecker;




            // If any field is empty, set isEmptyFields flag to true
            if(courseField.getText().isEmpty() || instructorField.getText().isEmpty() ||
                    universityField.getText().isEmpty() || studentField.getText().isEmpty())
            {
                isEmptyFields = true;
            }
            else
                isEmptyFields = false;
            // Display error message if there are empty fields
            if(isEmptyFields)
            {
            errorLabel.setText("Please fill all fields");
            errorLabel.setTextFill(Color.RED);
            }

            // If all fields are filled, try to add the course
            if(!isEmptyFields)
            {
                try {
                    /*
                     * Cast students Field to an integer, throws NumberFormatException if unsuccessful
                     */

                    numberOfStudents = Integer.parseInt(studentCount);
                    Instructor newInst = new Instructor();
                    newInst.setLastName(instructorName);


                    // Data is valid, so create new Department object and populate data
                    newCours = new Course(courseName, newInst, universityName, numberOfStudents);

                    // Loop through existing departments to check for duplicates
                    for (Course course : courseList) {
                        duplicateChecker = course;

                        if (duplicateChecker.getName().equals(courseField.getText()))
                        {
                            if(duplicateChecker.getInstructor().getLastName().equals(instructorField.getText()))
                            throw new Exception();
                        }
                    }

                        // and if exist do not add it to the list and display a message


                            if (textArea.getText().equals("No Courses"))
                                textArea.setText("");
                            courseList.add(newCours);
                            selectPane.updateCourseList(newCours);
                            errorLabel.setText("Course added.");
                            errorLabel.setTextFill(Color.RED);
                            textArea.appendText(newCours.toString());
                            courseField.clear();
                            instructorField.clear();
                            universityField.clear();
                            studentField.clear();


                }//end of try
             catch (NumberFormatException e)
             {
                 // If the number of students entered was not an integer, display an error

                     errorLabel.setText("Please input an integer for the number of students");

                 }

               catch (Exception e)
                {
                    // Catches generic exception and displays message
                    // Used to display 'Course is not added - already exist' message if course already exist
                    errorLabel.setText("Course is not added - already exist");
                }
            }

        } //end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class


