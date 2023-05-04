package Commands;

import ExecutionContext.Context;
import Factory.Command;
import Input.CommandContext;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.*;

public class SqrtOpTest {

    @Test
    public void TestDoMethod()
    {
        Command com = new SqrtOp();
        Context context = new Context();

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        Map<String, Float> parameters = new HashMap<>();
        parameters.put("a", 0.5f);
        parameters.put("b", 1f);
        context.setStack(stack);
        context.setParameters(parameters);
        String[] arguments = new String[] {"c", "3"};
        CommandContext command = new CommandContext("SQRT", arguments);
        com.Do(context,command.getArguments());
        stack = context.getStack();
        String n = stack.peek();
        assertEquals(n,"1.0");
    }

    @Test
    public void TestDoMethodEx()
    {
        Command com = new SqrtOp();
        Context context = new Context();

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        Map<String, Float> parameters = new HashMap<>();
        parameters.put("a", 0.5f);
        parameters.put("b", -1f);
        context.setStack(stack);
        context.setParameters(parameters);
        String[] arguments = new String[] {"c", "3"};
        CommandContext command = new CommandContext("SQRT", arguments);
        int fail = com.Do(context,command.getArguments());
        assertEquals(fail,1);
    }
}