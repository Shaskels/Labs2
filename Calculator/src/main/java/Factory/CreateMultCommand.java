package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreateMultCommand extends CommandCreator{

    public static final Logger logger = Logger.getLogger(
            CreateMultCommand.class.getName());
    private String type = "*";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> MultCommand = Class.forName(classes.get(type));
            Command mult = (Command)MultCommand.newInstance();
            logger.info("Class Mult was created");
            return mult;
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

