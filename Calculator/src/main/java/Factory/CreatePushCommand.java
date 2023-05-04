package Factory;

import java.util.Map;

public class CreatePushCommand extends CommandCreator{

    private String type = "PUSH";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandPush = Class.forName(classes.get(type));
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
