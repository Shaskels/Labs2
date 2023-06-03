package Factory;

import java.util.Map;
import java.util.logging.Logger;

public class CreatePopCommand extends CommandCreator {
    public static final Logger logger = Logger.getLogger(
            CreatePopCommand.class.getName());
    private String type = "POP";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandPop = Class.forName(classes.get(type));
            Command pop = (Command) CommandPop.newInstance();
            logger.info("Class Pop was created");
            return pop;
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
