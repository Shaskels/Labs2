package Factory;

public abstract class CommandCreator {
    public abstract Command CreateCommand();
    public abstract String getType();
}
