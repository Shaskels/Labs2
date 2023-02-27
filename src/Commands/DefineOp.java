package Commands;
import java.util.Map;
import ExecutionContext.Context;
import Factory.Command;

public class DefineOp implements Command {
    public void Do(Context con, String[] args){
        Map<String, Float> map = con.getParameters();
        float num = Float.parseFloat(args[1]);
        map.put(args[0], num);
    }
}
