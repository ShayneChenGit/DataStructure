package mymap;

import common.IIterator;
import myList.IList;
import common.IPosition;
import common.IteratorElement;
import myList.List_DLNode;

public class Map_DLNode implements IMap{
    private IList L;
    private IEqualityTester T;

    public Map_DLNode() {
        this(new EqualityTesterDeafult());
    }

    public Map_DLNode(IEqualityTester t) {
        L = new List_DLNode();
        T = t;
    }

    @Override
    public int getSize() {
        return L.getSize();
    }

    @Override
    public boolean isEmpty() {
        return L.isEmpty();
    }

    @Override
    public Object get(Object key) {
        IIterator p = L.positions();
        while(p.hasNext()){
            IPosition pos = (IPosition) p.getNext();
            IEntry entry = (EntryDefault)pos.getElem();
            if(T.isEqualTo(entry.getKey(), key)){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        IIterator p = L.positions();
        while (p.hasNext()){
            IPosition pos = (IPosition) p.getNext();
            IEntry entry = (IEntry) pos.getElem();
            if(T.isEqualTo(entry.getKey(), key)){
                Object oldValue = entry.getValue();
                L.replace(pos, new EntryDefault(key, value));
                return oldValue;
            }
        }
        L.insertFirst(new EntryDefault(key,value));
        return null;
    }

    @Override
    public Object remove(Object key) {
        IIterator p = L.positions();
        while (p.hasNext()){
            IPosition pos = (IPosition) p.getNext();
            IEntry entry = (IEntry) pos.getElem();
            if(T.isEqualTo(entry.getKey(),key)){
                Object oldValue = entry.getValue();
                L.remove(pos);
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public IIterator entries() {
        return new IteratorElement(L);
    }
}
