package Factory;

public class CreateMultCommand extends CommandCreator{

    private String type = "*";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> MultCommand = Class.forName("Commands.MultOp");
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
