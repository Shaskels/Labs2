package Commands;
import java.util.Map;
import ExecutionContext.Context;
import Factory.Command;

public class DefineOp implements Command {
    public void Do(Context con, String[] args){
        Map<String, Float> map = con.getParameters();
        float num = 0;
        try {
            num = Float.parseFloat(args[1]);
        }
        catch (NumberFormatException error){
            System.out.println(error);
            return;
        }
        map.put(args[0], num);
    }
}
