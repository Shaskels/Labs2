package Commands;

import ExecutionContext.Context;

public class MultOp {
    public void Mult(Context con, String[] args){
        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[1]);
        float res = num2 * num1;
    }
}
