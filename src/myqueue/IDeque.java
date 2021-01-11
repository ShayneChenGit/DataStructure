package myqueue;

import myException.ExceptionQueueEmpty;

import javax.print.attribute.standard.JobKOctets;

/**
 * 双端queue
 */
public interface IDeque {

    int getSize();

    boolean isEmpty();

    Object first() throws ExceptionQueueEmpty;

    Object last() throws ExceptionQueueEmpty;

    void insertFirst(Object obj);

    void insertLast(Object obj);

    Object removeFirst() throws ExceptionQueueEmpty;

    Object removeLast() throws ExceptionQueueEmpty;

    void Traversal();
}
