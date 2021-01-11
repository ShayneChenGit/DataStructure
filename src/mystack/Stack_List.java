package mystack;

import common.Node;
import myException.ExceptionStackEmpty;

public class Stack_List implements IStack{

    protected Node top;
    protected int size;

    public Stack_List() {
        top=null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (top==null)?true:false;
    }

    @Override
    public Object top() throws ExceptionStackEmpty {
        if(isEmpty()){
            throw new ExceptionStackEmpty("stack empty");
        }
        return top.getElem();
    }

    @Override
    public void push(Object ele) {
        Node v = new Node(ele, top);
        top = v;
        size++;
    }

    @Override
    public Object pop() throws ExceptionStackEmpty {
        if(isEmpty()){
            throw new ExceptionStackEmpty("stack empty");
        }
        Object temp = top.getElem();
        top = top.getNext();
        size--;
        return temp;
    }
}
