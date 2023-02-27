package Factory;

public class CreatePopCommand extends CommandCreator {

    private String type = "POP";
    @Override
    public Command CreateCommand(){
        try{
            Class<?> CommandPop = Class.forName("Commands.PopOp");
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

    public String getType(){
        return type;
    }
}
