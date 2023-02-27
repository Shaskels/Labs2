package Errors;

public class MyException extends Exception{
    private String errorCode;

    public MyException(String message){
        super(message);
        this.errorCode = message;
    }

    public String getErrorCode(){
        return errorCode;
    }
}
