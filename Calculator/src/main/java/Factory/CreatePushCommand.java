package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreatePushCommand extends CommandCreator{

    public static final Logger logger = Logger.getLogger(
            CreatePushCommand.class.getName());
    private String type = "PUSH";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandPush = Class.forName(classes.get(type));
            Command push = (Command) CommandPush.newInstance();
            logger.info("Class Push was created");
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
