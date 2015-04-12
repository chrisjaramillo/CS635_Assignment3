/**
 * Created by cxj8923 on 4/11/15.
 */
public class PenUpCommand implements Command {

    private Turtle subject;
    public PenUpCommand(Turtle toPenUp) {
        subject = toPenUp;
    }

    public void execute() {
        subject.penUp();
    }

    public void undo(){
        subject.penDown();
    }
}
