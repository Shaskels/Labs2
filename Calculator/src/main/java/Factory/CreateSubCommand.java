package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreateSubCommand extends CommandCreator{

    public static final Logger logger = Logger.getLogger(
            CreateSubCommand.class.getName());
    private String type = "-";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> SubCommand = Class.forName(classes.get(type));
            Command sub = (Command)SubCommand.newInstance();
            logger.info("Class Sub was created");
            return sub;
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
