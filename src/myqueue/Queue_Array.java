package myqueue;

import myException.ExceptionQueueEmpty;
import myException.ExceptionQueueFull;

/**
 * 基于循环列表
 */
public class Queue_Array implements IQueue {

    public static final int CAPACITY = 1000;
    protected int capacity;
    protected Object[] Q;
    protected int f = 0; //队首位置
    protected int r = 0; //队尾位置

    public Queue_Array() {
        this(CAPACITY);
    }

    public Queue_Array(int capacity) {
        this.capacity = capacity;
        Q = new Object[this.capacity];
    }

    @Override
    public int getSize() {
        return (capacity-f+r)%capacity;
    }

    @Override
    public boolean isEmpty() {
        return (f==r);
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if(isEmpty()){
            throw new ExceptionQueueEmpty("queue empty");
        }
        return Q[f];
    }

    @Override
    public void enqueue(Object obj) throws ExceptionQueueFull {
        if(getSize()==capacity-1){
            throw new ExceptionQueueFull("queue full");
        }
        Q[r] = obj;
        r=(r+1)%capacity;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        if(isEmpty()){
            throw new ExceptionQueueEmpty("queue empty");
        }
        Object elem =Q[f];
        Q[f] = null;
        f = (f+1)%capacity;
        return elem;
    }

    @Override
    public void Traversal() {
        for(int i=f; i<r; i++){
            System.out.print(Q[i]+" ");
        }
        System.out.println();
    }
}
