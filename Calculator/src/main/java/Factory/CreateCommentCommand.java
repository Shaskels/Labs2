package Factory;

import org.example.Main;

import java.util.Map;
import java.util.logging.Logger;

public class CreateCommentCommand extends CommandCreator {

    public static final Logger logger = Logger.getLogger(
            CreateCommentCommand.class.getName());
    private String type = "#";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandComment = Class.forName(classes.get(type));
            Command comment = (Command)CommandComment.newInstance();
            logger.info("Class Comment was created");
            return comment;
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

