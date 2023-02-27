package Factory;

public class CreateSubCommand extends CommandCreator{

    private String type = "-";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> SubCommand = Class.forName("Commands.SubOp");
            Command sub = (Command)SubCommand.newInstance();
            return sub;
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
