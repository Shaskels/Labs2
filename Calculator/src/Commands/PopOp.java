package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class PopOp implements Command {
    public void Do(Context con, String[] args){
        try {
            Stack<String> stack = con.getStack();
            stack.pop();
        }
        catch (EmptyStackException error){
            System.out.println(error);
        }
    }
}
