package myException;

public class ExceptionNoSuchElement extends RuntimeException{
    public ExceptionNoSuchElement(String err){
        super(err);
    }
}
