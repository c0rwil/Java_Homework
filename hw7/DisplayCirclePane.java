/*
 * Assignment #7
 *
 * Name: Carlos R. Corral-Williams
 * Student ID: 1222280826
 * Lecture: MWF 10:10 AM - 11:00 AM
 * Description:  This creates the GUI for the colorful circle generator program.
 *
 */


import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DisplayCirclePane extends GridPane
{

    // add instance variables
    private boolean deleted;
    private ArrayList<Circle> circleList;
    private GridPane ctrlPane;
    private CanvasPane canvas; // where to draw Circles
    private ComboBox<String> comboBoxColors;
    private Button btnErase, btnUndo;
    private Color inUseColor;





    //constructor
    public DisplayCirclePane()
    {
        // Initialize data models
        circleList = new ArrayList<>();
        // step 1: initialize instance variables & set up the layout
        ctrlPane = new GridPane();
        comboBoxColors = new ComboBox<>();
        comboBoxColors.getItems().addAll("Black","Red","Green","Blue","Orange");
        comboBoxColors.getSelectionModel().selectFirst();
        btnErase = new Button("Erase");
        btnUndo = new Button("Undo");


        // Instantiate
        ctrlPane.add(btnUndo,0,0);
        ctrlPane.add(btnErase,1,0);
        ctrlPane.add(comboBoxColors,2,0);

        // Create a pane for drawing circles
        canvas = new CanvasPane();
        canvas.setStyle("-fx-background-color: white;");

        //step 3 - register your canvas to listen to mouse events
        PointerHandler doesThisFixYou = new PointerHandler();
        canvas.setOnMousePressed(doesThisFixYou);
        canvas.setOnMouseDragged(doesThisFixYou);
        canvas.setOnMouseReleased(doesThisFixYou);

        // Resize the canvas automatically
        GridPane.setVgrow(canvas, Priority.ALWAYS);
        GridPane.setHgrow(canvas, Priority.ALWAYS);
        // Make the ComboBox of colors to fill the space of the control panel
        comboBoxColors.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(comboBoxColors, Priority.ALWAYS);
        // Set the preferred size of the control buttons (1/3 the size of the
        // initial window)
        double btnPrefWidth = Assignment7.WINSIZE_X / 3;

        btnErase.setPrefSize(btnPrefWidth, 1);
        btnUndo.setPrefSize(btnPrefWidth,1);
        comboBoxColors.setPrefSize(btnPrefWidth,1);
        canvas.getChildren().addAll(new Circle());

        //step3 : register your buttons and Combobox with its handler objects
        ButtonHandler buttonFix = new ButtonHandler();
        btnErase.setOnAction(buttonFix);
        btnUndo.setOnAction(buttonFix);
        comboBoxColors.setOnAction(new ColorComboBoxHandler());

        this.add(ctrlPane,0,0);
        this.add(canvas,0,1);

    }

    /**
     * CanvasPane is the panel where Circles will be drawn on.
     */
    private class CanvasPane extends Pane
    {   //instance variables
        private boolean isPlaceholderOn;
        private Circle drawn;
        public CanvasPane()
        {
            //implement the constructor
            drawn = new Circle(8,inUseColor);
        }
        public Circle findDrawnCircle()
        {
            drawn.setFill(drawn.getStroke());
            return drawn;
        }
        public void tracerCircle()
        {

            isPlaceholderOn = false;
            drawn = new Circle();
            drawn.setStrokeWidth(8);
            drawn.setFill(Color.WHITE);
            drawn.setStroke(Color.BLACK);

        }
        public void drawPlaceHolder(double x, double y, double radius)
        {
            // Change the position of the placeholder
            //write your code here

            drawn.setCenterX(x);
            drawn.setCenterY(y);
            drawn.setRadius(radius);
            // If this is the first time we draw the placeholder, add it to the canvas
            if (!isPlaceholderOn)
            {
                //write your code here
                drawn.setStroke(Color.valueOf(comboBoxColors.getValue()));
                isPlaceholderOn = true;
                this.getChildren().add(drawn);
            }

        }

        public void erasePlaceHolder()
        {
            // Simply remove the placeholder Circle from the canvas
           // write your code here

            if(isPlaceholderOn)
            {
                canvas.getChildren().remove(drawn);
                isPlaceholderOn = false;
                deleted = false;
            }
        }

        /**
         * Erase and redraw all Circles in the Circle list (not including the
         * placeholder)
         */
        public void repaint()
        {
            // Redraw all circles in the list
            this.getChildren().clear();
            for (Circle c : circleList)
            {
                this.getChildren().add(c);
            }

            // Make the control panel always visible
            ctrlPane.toFront();
        }
        public void changeColor (Color color)
        {
            drawn.setStroke(color);
        }

    }

    /**
     * Step 2: ButtonListener defines actions to take in case the "Undo" or "Erase"
     * button is clicked
     */
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        private ArrayList<Circle> circles = new ArrayList<>();
        @Override
        public void handle(ActionEvent e)
        {
            Object source = e.getSource();

            // Check if source refers to the Erase button

            if (source == btnErase)
            {

                //write your code here
                circles.clear();
                circles.addAll(circleList);
                circleList.clear();
                canvas.repaint();
                deleted = true;

            }
            // Check if source refers to the Undo button
            else if (source == btnUndo)
            {
                // Erase the last Circle in the list
                // write your code here
                if(deleted)
                {
                    deleted = false;
                    circleList.addAll(circles);
                }
                else if (!circleList.isEmpty())
                {
                    circleList.remove(circleList.size() - 1);
                }
                // Repaint the Canvas
                canvas.repaint();
            }
        }

    }

    /**
     * Step2: A listener class used to set the color chosen by the user via the
     * ComboBox of Colors.
     */
    private class ColorComboBoxHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent e)
        {
            //write your code here
            ArrayList<Color> circleColorOptions = new ArrayList<>();
            circleColorOptions.add(Color.BLACK);
            circleColorOptions.add(Color.RED);
            circleColorOptions.add(Color.GREEN);
            circleColorOptions.add(Color.BLUE);
            circleColorOptions.add(Color.ORANGE);
            String colorValue = comboBoxColors.getValue();
            if(colorValue.equals("Black"))
                inUseColor = circleColorOptions.get(0);
            if(colorValue.equals("Red"))
                inUseColor = circleColorOptions.get(1);
            if(colorValue.equals("Green"))
                inUseColor = circleColorOptions.get(2);
            if(colorValue.equals("Blue"))
                inUseColor = circleColorOptions.get(3);
            if(colorValue.equals("Orange"))
                inUseColor = circleColorOptions.get(4);


        }

    }

    /**
     * A listener class that handles any mouse events on the Canvas
     */
    private class PointerHandler implements EventHandler<MouseEvent>
    {
        // 1=pressed, 2=dragged, 3=released
        private double x1, y1, x2, y2,radius;

        @Override
        public void handle(MouseEvent e)
        {
            //write your code here
            if(e.getEventType()==MouseEvent.MOUSE_PRESSED)
            {
                //get x and y coordinate where we click the mouse
                x1=e.getX();
                y1=e.getY();
                //create a new circle
                canvas.tracerCircle();
                canvas.changeColor(inUseColor);
                canvas.drawPlaceHolder(x1,y1,12);
            }
            else if(e.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                 x2 = e.getX();
                 y2 = e.getY();

                radius = getDistance(x1,y1,x2,y2);
                canvas.drawPlaceHolder(x2,y2,radius);
            }
            else if(e.getEventType() == MouseEvent.MOUSE_RELEASED)
            {
                // Now fill newly created circle with color and add to arrayList of circles
                circleList.add(canvas.findDrawnCircle());
                canvas.erasePlaceHolder();
                canvas.repaint();
            }

        }

        /**
         * A helper method in case you need it. Get the Euclidean distance between (x1,y1) and (x2,y2)
         */
        private double getDistance(double x1, double y1, double x2, double y2)
        {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

    }//end of class PointerHandler
}//end of DisplayCirclePane class
