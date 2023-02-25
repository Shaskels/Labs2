package Factory;

public class CreateStackCommand extends Creator{
    @Override
    public Command CreateCommand(){
        try{
            Class<?> CommandPop = Class.forName("Commands.StackOp");
            Command pop = (Command) CommandPop.newInstance();
            return pop;
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
}
