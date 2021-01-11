package myException;

public class ExceptionStackFull extends RuntimeException{
    public ExceptionStackFull(String err){
        super(err);
    }
}
