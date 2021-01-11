package mystack;

import myException.ExceptionStackEmpty;

public interface IStack {
    int getSize();

    boolean isEmpty();

    Object top() throws ExceptionStackEmpty;

    void push(Object ele);

    Object pop() throws ExceptionStackEmpty;
}
