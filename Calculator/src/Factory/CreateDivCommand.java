package Factory;

public class CreateDivCommand extends CommandCreator{

    private String type = "/";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> DivCommand = Class.forName("Commands.DivOp");
            Command div = (Command)DivCommand.newInstance();
            return div;
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
