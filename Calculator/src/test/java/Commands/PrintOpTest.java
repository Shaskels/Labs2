package Commands;

import ExecutionContext.Context;
import Factory.Command;
import Input.CommandContext;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.*;

public class PrintOpTest {

    @Test
    public void TestDoMethodEx()

    {
        Command com = new PrintOp();
        Context context = new Context();

        Stack<String> stack = new Stack<>();
        Map<String, Float> parameters = new HashMap<>();
        context.setStack(stack);
        context.setParameters(parameters);
        String[] arguments = new String[] {"c", "3"};
        CommandContext command = new CommandContext("PRINT", arguments);
        int fail = com.Do(context,command.getArguments());
        assertEquals(fail,"a");
    }
}