package myException;

public class ExceptionBoundaryViolation extends RuntimeException{
    public ExceptionBoundaryViolation(String err){
        super(err);
    }
}
