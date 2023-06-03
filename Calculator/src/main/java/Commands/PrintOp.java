package Commands;

import ExecutionContext.Context;
import Factory.Command;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Logger;

public class PrintOp implements Command {

    public static final Logger logger = Logger.getLogger(
            PrintOp.class.getName());

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
        logger.info("Command Print done");
        return 0;
    }
}

