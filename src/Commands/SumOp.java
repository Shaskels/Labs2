package Commands;
import Factory.Command;
import ExecutionContext.Context;
public class SumOp implements Command{
    public void Do(Context con, String[] args){
        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[1]);
        float res = num1 + num2;
    }
}
