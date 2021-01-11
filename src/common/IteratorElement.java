package common;

import common.IIterator;
import common.IPosition;
import myException.ExceptionNoSuchElement;
import myList.IList;

public class IteratorElement implements IIterator {
    private IList list;
    private IPosition nextPosition;

    public IteratorElement() {
        list = null;
    }

    public IteratorElement(IList L) {
        list = L;
        if(list.isEmpty()){
            nextPosition = null;
        } else {
            nextPosition = list.first();
        }
    }

    @Override
    public boolean hasNext() {
        return (null != nextPosition);
    }

    @Override
    public Object getNext() {
        if(!hasNext()){
            throw new ExceptionNoSuchElement("has no next element");
        }
        IPosition currentPosition = nextPosition;
        if(currentPosition == list.last()){
            nextPosition = null;
        } else {
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition.getElem();
    }
}
