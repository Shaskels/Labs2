package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreateSqrtCommand extends CommandCreator{

    public static final Logger logger = Logger.getLogger(
            CreateSqrtCommand.class.getName());
    private String type = "SQRT";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> SqrtCommand = Class.forName(classes.get(type));
            Command sqrt = (Command)SqrtCommand.newInstance();
            logger.info("Class Sqrt was created");
            return sqrt;
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
