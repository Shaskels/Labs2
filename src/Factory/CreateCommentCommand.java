package Factory;

public class CreateCommentCommand extends Creator{
    @Override
    public Command CreateCommand(){
        try{
            Class<?> CommandComment = Class.forName("Commands.CommentOp");
            Command comment = (Command)CommandComment.newInstance();
            return comment;
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
