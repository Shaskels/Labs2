package ExecutionContext;

import java.util.Stack;
import java.util.Map;
public class Context {
    private Stack<String> stack;
    private Map<String, Float> parameters;

    public Stack<String> getStack(){
        return stack;
    }
    public Map<String, Float> getParameters(){
        return parameters;
    }

    public void setStack(Stack<String> stack){
        this.stack = stack;
    }

    public void setParameters(Map<String, Float> parameters){
        this.parameters = parameters;
    }
}
