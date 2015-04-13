/**
 * Created by cxj8923 on 4/11/15.
 */
public class MoveConstantCommand implements Command {
    private Turtle subject;
    private int distance;

    public MoveConstantCommand(Turtle toMove, int distance)
    {
        subject = toMove;
        this.distance = distance;
    }
    public void execute()
    {
        subject.move(distance);
    }

    public void undo()
    {
        subject.unmove(distance);

    }
}
