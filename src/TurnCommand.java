/**
 * Created by cxj8923 on 4/11/15.
 */
public class TurnCommand implements Command {
    private Turtle subject;
    private int degrees;

    public TurnCommand(Turtle toTurn, int degrees)
    {
        subject = toTurn;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        subject.turn(degrees);
    }

    @Override
    public void undo() {
        subject.turn(degrees*-1);
    }
}
