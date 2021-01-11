package common;

public class Node implements IPosition {

    private Object element;
    private Node next;

    public Node() {
        this(null,null);
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public Object getElem() {
        return element;
    }

    @Override
    public Object setElem(Object e) {
        Object oldElem = element;
        element = e;
        return oldElem;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
