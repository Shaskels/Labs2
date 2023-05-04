package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class PrintOp implements Command {
    public int Do(Context con,String[] args){
        try {
            Stack<String> stack = con.getStack();
            String sym = stack.peek();
            System.out.println(sym);
        }
        catch (EmptyStackException error){
            System.out.println(error);
            return 1;
        }
        return 0;
    }
}

