import Factory.Config;
import Input.Program;
import Commands.Handler;

public class Main {
    public static void main(String[] args) {
        Config config = new Config("ConfFile.txt");
        Program cp = new Program();
        cp.Parse(args);
        Handler h = new Handler();
        h.Processing(cp,config);
    }
}