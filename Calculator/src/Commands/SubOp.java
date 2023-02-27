package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.Map;
import java.util.Stack;

public class SubOp implements Command {
    private Float getNums(Context con, String arg){
        float num1;
        try {
            num1 = Float.parseFloat(arg);
        }
        catch(NumberFormatException error){
            Map<String, Float> parameters = con.getParameters();
            if(parameters.containsKey(arg))
                num1 = parameters.get(arg);
            else
                return null;
        }
        return num1;
    }
    public void Do(Context con, String[] args){
        Stack<String> stack = con.getStack();
        String arg1 = stack.pop();
        String arg2 = stack.pop();
        float num1 = getNums(con, arg1);
        float num2 = getNums(con, arg2);
        float res = num1 - num2;
        stack.push(Float.toString(res));
    }
}
