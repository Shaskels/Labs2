package Factory;

import java.util.Map;

public class CreateSqrtCommand extends CommandCreator{

    private String type = "SQRT";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> SqrtCommand = Class.forName(classes.get(type));
            Command sqrt = (Command)SqrtCommand.newInstance();
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
