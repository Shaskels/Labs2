package Commands;
import ExecutionContext.Context;
import Factory.Command;
import Input.CommandContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.*;

public class CommentOpTest {

    @Test
    public void TestDoMethod()
    {
        Command com = new CommentOp();
        Context context = new Context();
        Stack<String> stack = new Stack<>();
        stack.push("a");
        Map<String, Float> parameters = new HashMap<>();
        parameters.put("a", 0.5f);
        context.setStack(stack);
        context.setParameters(parameters);
        CommandContext command = new CommandContext("COMMENT",null);
        com.Do(context,command.getArguments());
        assertEquals(stack.peek(), "a");
    }
}