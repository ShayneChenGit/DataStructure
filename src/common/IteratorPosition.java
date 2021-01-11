package common;

import common.IIterator;
import common.IPosition;
import myException.ExceptionNoSuchElement;
import myList.IList;

public class IteratorPosition implements IIterator {
    private IList list;
    private IPosition nextPosition;

    public IteratorPosition() {
        list = null;
    }

    public IteratorPosition(IList L) {
        list = L;
        if(list.isEmpty()){
            nextPosition = null;
        }else {
            nextPosition=list.first();
        }

    }

    @Override
    public boolean hasNext() {
        return (nextPosition!=null);
    }

    @Override
    public Object getNext() {
        if(!hasNext()){
            throw new ExceptionNoSuchElement("Has no next element");
        }
        IPosition currentPosition = nextPosition;
        if(currentPosition == list.last()){
            nextPosition = null;
        } else{
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition;
    }
}
