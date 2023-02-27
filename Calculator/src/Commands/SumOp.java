package Commands;
import Errors.MyException;
import Factory.Command;
import ExecutionContext.Context;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

public class SumOp implements Command{

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
        try {
            Stack<String> stack = con.getStack();
            String arg1 = stack.pop();
            String arg2 = stack.pop();
            Float num1 = getNums(con, arg1);
            Float num2 = getNums(con, arg2);
            if (num1 == null || num2 == null)
                throw new MyException("Такого аргумента нет");
            float res = num1 + num2;
            stack.push(Float.toString(res));
        }
        catch(EmptyStackException error){
            System.out.println(error);
        }
        catch (MyException error){
            System.out.println(error.getErrorCode());
        }
    }
}
