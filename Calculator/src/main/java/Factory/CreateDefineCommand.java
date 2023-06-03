package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreateDefineCommand extends CommandCreator {

    public static final Logger logger = Logger.getLogger(
            CreateDefineCommand.class.getName());
    private String type = "DEFINE";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandDefine = Class.forName(classes.get(type));
            Command define = (Command)CommandDefine.newInstance();
            logger.info("Class Define was created");
            return define;
        }
        catch (ClassNotFoundException error){
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
