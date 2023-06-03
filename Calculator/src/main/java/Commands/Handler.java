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
import java.util.logging.Logger;

public class Handler {

    public static final Logger logger = Logger.getLogger(
            Handler.class.getName());
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
                        int fail = op.Do(this.context, com.getArguments());
                        if (fail == 1)
                            throw new MyException("Что-то пошло не так(");
                        break;
                    }

            }
        }
        catch (MyException error){
            logger.info("Something went wrong in program execution");
            System.out.println(error.getErrorCode());
        }
    }
}
