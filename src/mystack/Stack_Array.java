package mystack;

import myException.ExceptionStackEmpty;
import myException.ExceptionStackFull;

public class Stack_Array implements IStack {

    public static final int CAPACITY = 1024;
    protected int capacity;
    protected Object[] s;
    protected int top = -1;

    public Stack_Array() {
        this(CAPACITY);
    }

    public Stack_Array(int capacity) {
        this.capacity = capacity;
        s = new Object[this.capacity];
    }

    @Override
    public int getSize() {
        return (top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (top < 1);
    }

    @Override
    public Object top() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("stack empty");
        }
        return s[top];
    }

    @Override
    public void push(Object ele) {
        if (getSize() == capacity) {
            throw new ExceptionStackFull("stack overflow");
        }
        s[++top] = ele;
    }

    @Override
    public Object pop() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("stack empty");
        }
        Object ele = s[top];
        s[top--] = null;
        return ele;
    }
}
