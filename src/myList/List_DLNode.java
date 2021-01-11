package myList;

import common.IPosition;
import common.IteratorElement;
import common.IteratorPosition;
import myException.ExceptionBoundaryViolation;
import myException.ExceptionListEmpty;
import myException.ExceptionPositionInvalid;

public class List_DLNode implements IList {

    protected int numElem;
    protected DLNode header, trailer;

    public List_DLNode() {
        numElem = 0;
        header = new DLNode(null, null, null);
        trailer = new DLNode(null, header, null);
        header.setNext(trailer);
    }

    protected DLNode checkPosision(IPosition p) throws ExceptionPositionInvalid{
        if(null ==p){
            throw new ExceptionPositionInvalid("the parameter is null");
        }
        if(header == p){
            throw new ExceptionPositionInvalid("header position is invalid");
        }
        if(trailer == p){
            throw new ExceptionPositionInvalid("trailer position is invalid");
        }
        DLNode temp = (DLNode)p;
        return temp;
    }

    @Override
    public int getSize() {
        return numElem;
    }

    @Override
    public boolean isEmpty() {
        return (numElem == 0);
    }

    @Override
    public IPosition first() {
        if(isEmpty()){
            throw new ExceptionListEmpty("List is empty");
        }
        return header.getNext();
    }

    @Override
    public IPosition last() {
        if(isEmpty()){
            throw new ExceptionListEmpty("List is empty");
        }
        return trailer.getPrev();
    }

    @Override
    public IPosition getNext(IPosition p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DLNode v = checkPosision(p);
        DLNode next = v.getNext();
        if(next == trailer){
            throw new ExceptionBoundaryViolation("try to exceed latter boundary of List");
        }
        return next;
    }

    @Override
    public IPosition getPrev(IPosition p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
        DLNode v = checkPosision(p);
        DLNode prev = v.getPrev();
        if(prev == header){
            throw new ExceptionBoundaryViolation("try to exceed former boundary of List");
        }
        return prev;
    }

    @Override
    public IPosition insertFirst(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e, header, header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;
    }

    @Override
    public IPosition insertLast(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e, trailer.getPrev(),trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        return newNode;
    }

    @Override
    public IPosition insertBefore(IPosition p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosision(p);
        numElem++;
        DLNode newNode = new DLNode(e, v.getPrev(), v);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        return newNode;
    }

    @Override
    public IPosition insertAfter(IPosition p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosision(p);
        numElem++;
        DLNode newNode = new DLNode(e, v, v.getNext());
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
        return newNode;
    }

    @Override
    public Object remove(IPosition p) throws ExceptionPositionInvalid {
        DLNode v = checkPosision(p);
        numElem--;
        DLNode vPrev = v.getPrev();
        DLNode vNext = v.getNext();
        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);
        Object vElem = v.getElem();
        v.setPrev(null);
        v.setNext(null);
        return vElem;
    }

    @Override
    public Object removeFirst() {
        return remove(header.getNext());
    }

    @Override
    public Object removeLast() {
        return remove(trailer.getPrev());
    }

    @Override
    public Object replace(IPosition p, Object e) throws ExceptionPositionInvalid {
        DLNode v = checkPosision(p);
        Object oldElem = v.getElem();
        v.setElem(e);
        return oldElem;
    }

    @Override
    public common.IIterator positions() {
        return new IteratorPosition(this);
    }

    @Override
    public common.IIterator elements() {
        return new IteratorElement(this);
    }
}
