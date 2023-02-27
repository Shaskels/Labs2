package Commands;
import Errors.MyException;
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

    public void Processing(Program program, Config config){
        try {
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
                    new CreatePrintCommand()
            };
            for (CommandContext com : toCalculate) {
                for (CommandCreator creator : creators)
                    if (com.getCommand() == creator.getType()) {
                        Command op = creator.CreateCommand(config);
                        if (op == null)
                            throw new MyException("Неправильное название класса команды");
                        op.Do(this.context, com.getArguments());
                        break;
                    }

            }
        }
        catch (MyException error){
            System.out.println(error.getErrorCode());
        }
    }
}
