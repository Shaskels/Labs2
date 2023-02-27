package Factory;

public class CreateDefineCommand extends CommandCreator {

    private String type = "DEFINE";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> CommandDefine = Class.forName("Commands.DefineOp");
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
