package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreateSumCommand extends CommandCreator {

    public static final Logger logger = Logger.getLogger(
            CreateSumCommand.class.getName());
    private String type = "+";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> SumCommand = Class.forName(classes.get(type));
            Command sum = (Command)SumCommand.newInstance();
            logger.info("Class Sum was created");
            return sum;
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

