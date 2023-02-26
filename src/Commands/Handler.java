package Commands;
import Input.CommandContext;
import Input.Program;

import java.util.List;

public class Handler {
    Program program;

    public Handler(Program program){
        this.program = program;
    }

    public void Processing(){
        List<CommandContext> toCalculate = program.getToCalculate();
        for(CommandContext com : toCalculate){
            
        }
    }
}
