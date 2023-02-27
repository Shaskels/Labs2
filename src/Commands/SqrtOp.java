package Commands;

import ExecutionContext.Context;
import Factory.Command;

public class SqrtOp implements Command {
    public void Do(Context con, String[] args){
        float num1 = Float.parseFloat(args[0]);
        double res = Math.sqrt(num1);
    }
}
