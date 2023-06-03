package Commands;

import ExecutionContext.Context;
import Factory.Command;
import Input.CommandContext;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.*;

public class DefineOpTest {

    @Test
    public void TestDoMethod()
    {
        Command com = new DefineOp();
        Context context = new Context();

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        Map<String, Float> parameters = new HashMap<>();
        parameters.put("a", 0.5f);
        context.setStack(stack);
        context.setParameters(parameters);
        String[] arguments = new String[] {"c", "3"};
        CommandContext command = new CommandContext("DEFINE", arguments);
        int fail = com.Do(context,command.getArguments());
        parameters = context.getParameters();
        float num = parameters.get("c");
        assertEquals(num,3f, 0);
        assertEquals(fail, 0);
    }

    @Test
    public void TestDoMethodEx(){
        Command com = new DefineOp();
        Context context = new Context();

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        Map<String, Float> parameters = new HashMap<>();
        parameters.put("a", 0.5f);
        context.setStack(stack);
        context.setParameters(parameters);
        String[] arguments = new String[] {"c", "ak"};
        CommandContext command = new CommandContext("DEFINE", arguments);
        int fail = com.Do(context,command.getArguments());
        parameters = context.getParameters();
        int num = 1;
        if(parameters.containsKey("c"))
            num = 0;
        assertEquals(num,1);
        assertEquals(fail, 1);
    }
}