package Factory;

import java.util.Map;

public class CreatePrintCommand extends  CommandCreator{

    private String type = "PRINT";
    @Override
    public Command CreateCommand(Config config){
        try{
            Map<String,String> classes = config.getClasses();
            Class<?> CommandPrint = Class.forName(classes.get(type));
            Command print = (Command) CommandPrint.newInstance();
            return print;
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
