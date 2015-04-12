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
    public void move(int distance){}

    public void unmove(int distance){}

    public void turn(int degrees){}

    public void penUp(){}

    public void penDown(){}

    public boolean isPenUp()
    {
        return true;
    }

    public int direction(){
        return 0;
    }

    public Point2D location(){
        return new Point2D.Double();
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
