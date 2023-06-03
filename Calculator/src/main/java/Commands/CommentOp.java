package Commands;

import Factory.Command;
import ExecutionContext.Context;

import java.util.logging.Logger;

public class CommentOp implements Command {

    public static final Logger logger = Logger.getLogger(
            CommentOp.class.getName());

    public int Do(Context con, String[] args){
        logger.info("Command Comment done");
        return 0;
    }
}
