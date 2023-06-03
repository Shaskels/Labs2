package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Logger;

public class PopOp implements Command {

    public static final Logger logger = Logger.getLogger(
            PopOp.class.getName());

    public int Do(Context con, String[] args){
        try {
            Stack<String> stack = con.getStack();
            stack.pop();
        }
        catch (EmptyStackException error){
            System.out.println(error);
            return 1;
        }
        logger.info("Command Pop done");
        return 0;
    }
}
