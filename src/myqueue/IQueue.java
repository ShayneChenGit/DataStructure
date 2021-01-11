package myqueue;

import myException.ExceptionQueueEmpty;
import myException.ExceptionQueueFull;

public interface IQueue {

    int getSize();

    boolean isEmpty();

    Object front() throws ExceptionQueueEmpty;

    void enqueue(Object obj) throws ExceptionQueueFull;

    Object dequeue() throws ExceptionQueueEmpty;

    void Traversal(); //便利

}
