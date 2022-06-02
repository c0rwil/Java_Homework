/**
 * BallPanel.java
 * Name:        Carlos Corral-Williams
 * Student ID:  1222280826
 * Lecture:     MWF 10:10am-11:00am
 * Description: Class is responsible for animation of two circle objects at varying speeds and directions.
 */


import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.AnimationTimer;

public class BallPanel extends Pane
{
    //instance variables
    private int x,y;
    private int delay;
    private int stepX,stepY;
    private final int RADIUS = 15;
    private Circle ball;
    private MovingBallTimer timer;


    //construct ballPanel by assigning values to variables, assigning background color
    public BallPanel(int x1, int y1, Color ballColor1, Color backColor1)
    {
        // assigning constants and parameters to variable value
        delay = 20;
        x=x1;
        y=y1;
        stepX=3;stepY=0;

        // constructing a background and filling it with assigned color value
        BackgroundFill backcol = new BackgroundFill(backColor1, null, null);
        Background backGroun = new Background(backcol);
        this.setBackground(backGroun);

        // constructing a  new circle, specified radius and ballcolors, x,y values
        ball = new Circle(x,y,RADIUS, ballColor1);
        // filling ball
        ball.setFill(ballColor1);
        //ball.setCenterX(x);ball.setCenterY(y);
        this.getChildren().add(ball);

        //start moving timer
        timer = new MovingBallTimer();
        timer.start();


    }
        // move ball up
         public void up()
        {
            stepX= 0;
            stepY=-3;
        }
        // move ball left
        public void left()
        {
            stepX=-3;
            stepY=0;
        }
        // stop move ball
        public void suspend()
        {
            stepX= 0;
            stepY=0;
            timer.stop();
        }
        // change delay of ball movement
        public void setDelay(int delay)
        {
            this.delay = delay;
        }
        // move ball down
        public void down()
        {
            stepX=0;
            stepY=3;
        }
        // move ball right
        public void right()
        {
            stepX= 3;
            stepY=0;
        }

        // responsible for the animation/updating position values/ keeping ball in bounds of the panels
    private class MovingBallTimer extends AnimationTimer
    {
        private long lastTimestamp = -1;
        private long time;


        public void handle(long now)
        {
            // update timestamp to current
            if(lastTimestamp == -1)
            {
                lastTimestamp = now;
            }
            //
            long timeElapsed = now - lastTimestamp;
            time+= timeElapsed;

            // 1 second = 1,000,000,000 nano-sec
            double timeInSeconds = time / 1_000_000_000.0;

            if(timeInSeconds >=delay)
            {
                // to stop ball from going out of boundary on x-plane
                if ( x < RADIUS || x>getWidth()-RADIUS)
                {
                    stepX*=-1; // change ball direction in x-axis
                }
                // to stop ball from going out of bounds on y-plane
                if (y<RADIUS | y>getHeight()- RADIUS)
                {
                    stepY *=-1; // change ball direction in y-axis
                }
                //adjust ball positions
                x += stepX;
                y += stepY;
                ball.setCenterX(x);
                ball.setCenterY(y);
                lastTimestamp=now;

            }

        }
}

}