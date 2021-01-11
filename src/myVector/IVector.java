package myVector;

import myException.ExceptionBoundaryViolation;

public interface IVector {
    int getSize();

    boolean isEmpty();

    Object getAtRank(int r) throws ExceptionBoundaryViolation;

    Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

    Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

    Object removeAtRank(int r) throws ExceptionBoundaryViolation;


}
