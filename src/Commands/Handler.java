package Commands;
import Factory.*;
import Input.CommandContext;
import Input.Program;
import ExecutionContext.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Map;

public class Handler {
    Context context;

    public Handler(){
        context = new Context();
        Stack<String> stack = new Stack<>();
        context.setStack(stack);
        Map<String, Float> parameters = new HashMap<>();
        context.setParameters(parameters);
    }

    public void Processing(Program program){
        List<CommandContext> toCalculate = program.getToCalculate();
        CommandCreator[] creators = {
                new CreateCommentCommand(),
                new CreateDefineCommand(),
                new CreatePopCommand(),
                new CreatePushCommand(),
                new CreateDivCommand(),
                new CreateMultCommand(),
                new CreateSubCommand(),
                new CreateSumCommand(),
                new CreateSqrtCommand(),
        };
        for(CommandContext com : toCalculate){
            for(CommandCreator creator: creators)
               if (com.getCommand() == creator.getType()){
                   Command op = creator.CreateCommand();
                   op.Do(this.context, com.getArguments());
               }

        }
    }
}
