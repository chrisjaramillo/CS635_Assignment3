/**
 * Created by cxj8923 on 4/11/15.
 */
public interface TurtleGenerator {
    void visitConstantNode(Constant aNode);
    void visitLookupVariableNode(LookupVariable aNode);
    void visitMoveNode(Move aNode);
    void visitPenDownNode(PenDown aNode);
    void visitPenUpNode(PenUp aNode);
    void visitRepeatNode(Repeat aNode);
    void visitTurnNode(Turn aNode);
    void visitVariableNode(Variable aNode);
}
