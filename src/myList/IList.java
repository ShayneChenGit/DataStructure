package myList;

import common.IPosition;
import myException.ExceptionBoundaryViolation;
import myException.ExceptionPositionInvalid;

public interface IList {
    int getSize();

    boolean isEmpty();

    IPosition first();

    IPosition last();

    IPosition getNext(IPosition p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;

    IPosition getPrev(IPosition p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;

    IPosition insertFirst(Object e);

    IPosition insertLast(Object e);

    IPosition insertBefore(IPosition p, Object e) throws ExceptionPositionInvalid;
    IPosition insertAfter(IPosition p, Object e) throws ExceptionPositionInvalid;

    Object remove(IPosition p) throws ExceptionPositionInvalid;

    Object removeFirst();

    Object removeLast();

    Object replace(IPosition p, Object e) throws ExceptionPositionInvalid;

    common.IIterator positions();

    common.IIterator elements();

}
