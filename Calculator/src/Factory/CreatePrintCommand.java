package Factory;

public class CreatePrintCommand extends  CommandCreator{

    private String type = "PRINT";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> CommandPrint = Class.forName("Commands.PrintOp");
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
