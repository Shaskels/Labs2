package Commands;
import java.util.Stack;
import ExecutionContext.Context;
import Factory.Command;

public class PushOp implements Command {

    public void Do(Context con,String[] args){
        Stack<String> stack = con.getStack();
        stack.push(args[0]);
    }
}
