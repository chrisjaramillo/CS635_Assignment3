/**
 * Created by cxj8923 on 4/11/15.
 */
public class PenDownCommand implements Command {
    Turtle subject;
    public PenDownCommand(Turtle toPenUp) {
        subject = toPenUp;
    }

    public void execute() {
        subject.penUp();
    }

    public void undo(){
        subject.penDown();
    }
}
