package Commands;
import java.util.Map;
import java.util.logging.Logger;

import ExecutionContext.Context;
import Factory.Command;

public class DefineOp implements Command {

    public static final Logger logger = Logger.getLogger(
            DefineOp.class.getName());

    public int Do(Context con, String[] args){
        Map<String, Float> map = con.getParameters();
        float num = 0;
        try {
            num = Float.parseFloat(args[1]);
        }
        catch (NumberFormatException error){
            System.out.println(error);
            return 1;
        }
        map.put(args[0], num);
        logger.info("Command Define done");
        return 0;
    }
}

