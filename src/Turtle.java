import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

/**
 * Created by Christopher on 4/8/2015.
 */
public class Turtle {
    private HashMap<String, Integer> variables;
    private int direction;
    private Point2D location;
    private boolean penDown;

    Turtle()
    {
        variables = new HashMap<String, Integer>();
        direction = 0;
        penDown = true;
        location = new Point2D.Double(0.0, 0.0);
    }
    public void move(int distance)
    {
        double radians = direction * Math.PI/180;
        double deltaX = Math.cos(radians) * distance;
        double deltaY = Math.sin(radians) * distance;
        double newX = location.getX() + deltaX;
        double newY = location.getY() + deltaY;
        location.setLocation(newX,newY);
    }

    public void unmove(int distance)
    {

    }

    public void turn(int degrees)
    {
        direction += degrees;
        direction = direction % 360;
        if(direction < 0)
        {
            direction += 360;
        }
    }

    public void penUp()
    {
        penDown = false;
    }

    public void penDown()
    {
        penDown = true;
    }

    public boolean isPenUp()
    {
        return !penDown;
    }

    public int direction()
    {
        return direction;
    }

    public Point2D location()
    {
        return location;
    }

    public void setVariables(String name, int value)
    {
        variables.put(name, value);
    }

    public int getVariable(String variableName)
    {
        return variables.get(variableName);
    }
}
