package Factory;

public abstract class CommandCreator {
    public abstract Command CreateCommand(Config config);
    public abstract String getType();
}
