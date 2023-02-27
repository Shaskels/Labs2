package Factory;

public class CreatePushCommand extends CommandCreator{

    private String type = "PUSH";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> CommandPush = Class.forName("Commands.PushOp");
            Command push = (Command) CommandPush.newInstance();
            return push;
        }
        catch(ClassNotFoundException error){
            System.out.println(error);
        }
        catch (InstantiationException error){
            System.out.println(error);
        }
        catch (IllegalAccessException error){
            System.out.println(error);
        }
        return null;
    }

    public String getType(){
        return type;
    }
}
