package Factory;

public class CreateSumCommand extends CommandCreator {

    private String type = "+";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> SumCommand = Class.forName("Commands.SumOp");
            Command sum = (Command)SumCommand.newInstance();
            return sum;
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
