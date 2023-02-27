import Input.Program;
import Commands.Handler;
import ExecutionContext.Context;
public class Main {
    public static void main(String[] args) {
        Program cp = new Program();
        cp.Parse(args);
        Handler h = new Handler();
        h.Processing(cp);
    }
}