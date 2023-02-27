package Commands;

import Errors.MyException;
import ExecutionContext.Context;
import Factory.Command;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Map;

public class SqrtOp implements Command {
    public void Do(Context con, String[] args){
        Stack<String> stack = con.getStack();
        String arg = null;
        float num1 = 0;
        try {
            arg = stack.pop();
            num1 = Float.parseFloat(arg);
            if(num1 < 0) throw new MyException("Невозможно извлечь корень");
        }
        catch(NumberFormatException error){
            Map<String, Float> parameters = con.getParameters();
            if(parameters.containsKey(arg))
                num1 = parameters.get(arg);
            else {
                System.out.println("Такого аргумента нет");
                return;
            }
            if(num1 < 0){
                System.out.println("Невозможно извлечь корень");
                return;
            }
        }
        catch (EmptyStackException error){
            System.out.println(error);
        }
        catch (MyException error){
            System.out.println(error.getErrorCode());
        }
        double res = Math.sqrt(num1);
        stack.push(Float.toString((float)res));
    }
}
