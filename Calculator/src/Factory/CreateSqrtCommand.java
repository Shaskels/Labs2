package Factory;

public class CreateSqrtCommand extends CommandCreator{

    private String type = "SQRT";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> SqrtCommand = Class.forName("Commands.SqrtOp");
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
