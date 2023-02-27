package Input;

public class CommandContext {
    private String command;
    private String[] arguments;

    public CommandContext(String command, String[] arguments){
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand(){
        return command;
    }

    public String[] getArguments(){
        return arguments;
    }
}
