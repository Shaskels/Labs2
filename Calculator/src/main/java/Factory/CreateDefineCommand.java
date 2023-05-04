package Factory;

import java.util.Map;

public class CreateDefineCommand extends CommandCreator {

    private String type = "DEFINE";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandDefine = Class.forName(classes.get(type));
            Command define = (Command)CommandDefine.newInstance();
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
