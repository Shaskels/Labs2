package Commands;
import java.util.Stack;
import java.util.logging.Logger;

import ExecutionContext.Context;
import Factory.Command;

public class PushOp implements Command {

    public static final Logger logger = Logger.getLogger(
            PushOp.class.getName());

    public int Do(Context con,String[] args){
        Stack<String> stack = con.getStack();
        stack.push(args[0]);
        logger.info("Command Push done");
        return 0;
    }
}
