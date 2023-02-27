package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.Stack;

public class PopOp implements Command {
    public void Do(Context con, String[] args){
        Stack<String> stack = con.getStack();
    }
}
