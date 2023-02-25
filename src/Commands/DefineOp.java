package Commands;
import java.util.HashMap;
import java.util.Map;
import ExecutionContext.Context;
public class DefineOp {
    public void Define (Context con, String[] symbols){
        Map<String, Float> map = con.getParameters();
        float num = Float.parseFloat(symbols[1]);
        map.put(symbols[0], num);
    }
}
