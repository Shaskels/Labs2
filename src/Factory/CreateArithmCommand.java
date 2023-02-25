package Factory;

public class CreateArithmCommand extends Creator {
    @Override
    public Command CreateCommand(){
        try{
            Class<?> ArithmCommand = Class.forName("Commands.ArithmeticOp");
            Command arithmetic = (Command)ArithmCommand.newInstance();
            return arithmetic;
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
}
