package myqueue;

import common.Node;
import myException.ExceptionQueueEmpty;
import myException.ExceptionQueueFull;

/**
 * 基于单链表
 */
public class Queue_List implements IQueue{
    protected Node head; //表首
    protected Node tail; //表尾
    protected int size;

    public Queue_List() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (0==size)?true:false;
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if(isEmpty()){
            throw new ExceptionQueueEmpty("queue empty");
        }
        return head.getElem();
    }

    @Override
    public void enqueue(Object obj) throws ExceptionQueueFull {
        Node node = new Node(obj,null);
        if(0==size){
            head = node;
        }else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        if(isEmpty()){
            throw new ExceptionQueueEmpty("queue empty");
        }
        Object obj = head.getElem();
        head = head.getNext();
        size--;
        if(0==size){
            tail=null;
        }
        return obj;
    }

    @Override
    public void Traversal() {
        Node p = head;
        while(null !=p){
            System.out.print(p.getElem()+" ");
            p.getNext();
        }
    }
}
