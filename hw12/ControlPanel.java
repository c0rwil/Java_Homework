
/**
 * ControlPanel.java
 * Name:        Carlos Corral-Williams
 * Student ID:  1222280826
 * Lecture:     MWF 10:10am-11:00am
 * Description: Class is responsible for controlling panes, adds buttons, sliders, labels, and BallPanels.
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ControlPanel extends GridPane
{
    // Predefined layout parameters

    private double widthCtrl;
    private double widthSlider;
    private double widthBallPanel;
    private double heightSlider;
    private double heightBox;
    
    // GUI Components

    private Button up1, down1, left1, right1, stop1;
    private Button up2, down2, left2, right2, stop2;
    private Slider slider1, slider2;
    private Label label1, label2;
    private BallPanel ball1, ball2;

    private VBox box11, box12, box13;
    private VBox box21, box22, box23;

    /**
     * Create a ControlPanel
     * 
     * @param width  the width of the window
     * @param height the height of the window
     */

    public ControlPanel(double width, double height)
    {
        // Predefined layout parameters
        widthCtrl = width * 0.2;
        widthSlider = width * 0.2;
        widthBallPanel = width - widthCtrl - widthSlider;
        heightSlider = height * 0.35;
        heightBox = height * 0.45;

        // Make boxes
        box11 = new VBox();
        box12 = new VBox();
        box13 = new VBox();
        box21 = new VBox();
        box22 = new VBox();
        box23 = new VBox();

        // Make 2 BallPanels

        int initXY = 50;
        ball1 = new BallPanel(initXY, initXY, Color.RED, Color.CYAN);
        ball2 = new BallPanel(initXY, initXY, Color.BLUE, Color.YELLOW);

        // Set the size of BallPanels
        // Note: They must have some size to show
        ball1.setPrefSize(widthBallPanel, heightBox);
        ball2.setPrefSize(widthBallPanel, heightBox);

        box13.getChildren().add(ball1);
        box23.getChildren().add(ball2);

        // Make 10 Buttons

        up1 = new Button("Up Red");
        down1 = new Button("Down Red");
        left1 = new Button("Left Red");
        right1 = new Button("Right Red");
        stop1 = new Button("Stop Red");

        up1.setOnAction(new ButtonListener());
        down1.setOnAction(new ButtonListener());
        left1.setOnAction(new ButtonListener());
        right1.setOnAction(new ButtonListener());
        stop1.setOnAction(new ButtonListener());

        box11.getChildren().addAll(up1, down1, left1, right1, stop1);

        up2 = new Button("Up Blue");
        down2 = new Button("Down Blue");
        left2 = new Button("Left Blue");
        right2 = new Button("Right Blue");
        stop2 = new Button("Stop Blue");

        up2.setOnAction(new ButtonListener());
        down2.setOnAction(new ButtonListener());
        left2.setOnAction(new ButtonListener());
        right2.setOnAction(new ButtonListener());
        stop2.setOnAction(new ButtonListener());

        box21.getChildren().addAll(up2, down2, left2, right2, stop2);

        // Create 2 Sliders & 2 Labels

        label1 = new Label("Red Ball Delay");
        slider1 = new Slider();
        setSliderStyle(slider1);

        box12.getChildren().addAll(label1, slider1);

        label2 = new Label("Blue Ball Delay");
        slider2 = new Slider();
        setSliderStyle(slider2);

        box22.getChildren().addAll(label2, slider2);

        // Organize the components in this GridPane

        this.add(box11, 0, 0);
        this.add(box12, 1, 0);
        this.add(box13, 2, 0);
        this.add(box21, 0, 1);
        this.add(box22, 1, 1);
        this.add(box23, 2, 1);

        // Optional style

        // Set the alignment of content of this GridPane
        this.setAlignment(Pos.CENTER);
        this.setVgap(4);
        // Set the width of Buttons & Sliders
        Control[] nodes = { up1, down1, left1, right1, stop1, up2, down2, left2, right2, stop2, slider1, slider2 };
        for (Control n : nodes)
        {
            n.setPrefWidth(widthCtrl);
        }
        // Set the height and alignment of VBoxes
        VBox[] boxes = { box11, box12, box13, box21, box22, box23 };
        for (VBox b : boxes)
        {
            b.setAlignment(Pos.CENTER);
            b.setPrefHeight(heightBox);
        }
    }

    /**
     * Default style of sliders
     */
    private int sliderMin = 0;
    private int sliderMax = 50;
    private int sliderMajorUnit = 10;
    private int sliderMinorUnit = 1;
    private int sliderDefault = 20;
    private Orientation sliderOrientation = Orientation.VERTICAL;
    private boolean sliderShowTickLabels = true;
    private boolean sliderShowTickMarks = true;

    /**
     * Set a common style for the given slider.
     * 
     * @param slider a slider to set the style
     */
    private void setSliderStyle(Slider slider)
    {
        // Set the default value of the slider
        slider.setValue(sliderDefault);
        // Set a value change listener
        slider.valueProperty().addListener(new SliderListener(slider));
        // Set the min/max of slider values
        slider.setMin(sliderMin);
        slider.setMax(sliderMax);
        // Set the unit of slider values
        slider.setMajorTickUnit(sliderMajorUnit);
        slider.setMinorTickCount(sliderMinorUnit);
        // Set the orientation of the slider
        slider.setOrientation(sliderOrientation);
        // Set the size of the slider
        slider.setPrefWidth(widthSlider);
        slider.setPrefHeight(heightSlider);
        // Show the tick labels
        slider.setShowTickLabels(sliderShowTickLabels);
        slider.setShowTickMarks(sliderShowTickMarks);
    }

    private class ButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            //stop1 is for stopping red
            if(event.getSource() == stop1)
            {
            ball1.suspend();
            }
            //up1 is for upping Red
            if(event.getSource() == up1)
            {
                ball1.up();
            }
            //down1 is for moving Red down
            if(event.getSource() == down1)
            {
                ball1.down();
            }
            //left1 is for moving Red left
            if(event.getSource() == left1)
            {
                ball1.left();
            }
            //right1 is for moving Red to the right
            if(event.getSource() == right1)
            {
                ball1.right();
            }
            //stop2 is for stopping blue
            if (event.getSource() == stop2)
            {
                ball2.suspend();
            }
            // up2 is for moving Blue up
            if(event.getSource() == up2)
            {
                ball2.up();
            }
            //down2 for moving Blue down
            if(event.getSource() == down2)
            {
                ball2.down();
            }
            //left2 for moving Blue left
            if(event.getSource() == left2)
            {
                ball2.left();
            }
            //right2 for moving Blue right
            if(event.getSource() == right2)
            {
                ball2.right();
            }

        } //end of method handle
    }//end of class

    private class SliderListener implements ChangeListener<Number>
    {
        private Slider slider;

        /**
         * @param slider the slider who registers this listener
         */
        public SliderListener(Slider slider)
        {
            this.slider = slider;
        }

        @Override

        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
        {
            int delay = newValue.intValue();
            
            // Change the delay according to the slider
            if (slider == slider1)
            {
                ball1.setDelay(delay);
            }
            else if (slider == slider2)
            {
                ball2.setDelay(delay);
            }
        }

    }

}
