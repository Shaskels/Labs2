package Commands;
import java.util.Stack;
import ExecutionContext.Context;
public class StackOp {

    public String myPush(Context con,String[] symbol){
        Stack<String> stack = con.getStack();
        return stack.push(symbol[0]);
    }
    public String myPop(Context con){
        Stack<String> stack = con.getStack();
        return stack.pop();
    }

    public String myPrint(Context con){
        Stack<String> stack = con.getStack();
        String sym = stack.peek();
        System.out.println(sym);
        return sym;
    }
}
