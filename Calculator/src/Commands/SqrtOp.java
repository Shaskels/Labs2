package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.Stack;
import java.util.Map;

public class SqrtOp implements Command {
    public void Do(Context con, String[] args){
        Stack<String> stack = con.getStack();
        String arg = stack.pop();
        float num1;
        try {
            num1 = Float.parseFloat(arg);
        }
        catch(NumberFormatException error){
            Map<String, Float> parameters = con.getParameters();
            if(parameters.containsKey(arg))
                num1 = parameters.get(arg);
            else
                return;
        }
        double res = Math.sqrt(num1);
        stack.push(Float.toString((float)res));
    }
}
