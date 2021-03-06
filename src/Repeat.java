import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christopher Jaramillo on 4/10/15.
 */
public class Repeat implements TurtleNode
{
    private TurtleNode repetitions;
    private List<TurtleNode> composite;

    Repeat(TurtleNode aNode)
    {
        repetitions = aNode;
        composite = new ArrayList<TurtleNode>();
    }
    @Override
    public int evaluate(Turtle values)
    {
        int count = repetitions.evaluate(values);
        for(int i=0;i < count; i++)
        {
            this.evaluateComposite(values);
        }
        return 0;
    }

    @Override
    public void accept(TurtleGenerator generator) {
        generator.visitRepeatNode(this);
    }

    private void evaluateComposite(Turtle values) {
        for(TurtleNode currentNode : composite)
        {
            currentNode.evaluate(values);
        }

    }

    public void addNode(TurtleNode aNode)
    {
        composite.add(aNode);
    }

    public List<TurtleNode> getList() {
        return composite;
    }

    public TurtleNode getRepetitions()
    {
        return repetitions;
    }

    @Override
    public String toString()
    {
        StringBuffer asString=new StringBuffer();
        asString.append("repeat " + repetitions.toString() + "\n");
        for(TurtleNode currentNode : composite)
        {
            asString.append("\t" + currentNode.toString() + "\n");
        }
        asString.append("end\n");
        return asString.toString();
    }
}