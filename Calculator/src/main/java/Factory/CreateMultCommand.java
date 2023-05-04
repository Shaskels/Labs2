package Factory;

import java.util.Map;

public class CreateMultCommand extends CommandCreator{

    private String type = "*";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> MultCommand = Class.forName(classes.get(type));
            Command mult = (Command)MultCommand.newInstance();
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

