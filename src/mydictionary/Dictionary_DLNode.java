package mydictionary;

import common.IIterator;
import common.IPosition;
import myList.IList;
import common.IteratorElement;
import myList.List_DLNode;
import mymap.EntryDefault;
import mymap.EqualityTesterDeafult;
import mymap.IEntry;
import mymap.IEqualityTester;

/**
 * 基于列表实现（无序）词典结构
 */
public class Dictionary_DLNode implements IDictionary{
    private IList L; //存放条目的列表
    private IEqualityTester T; //判等器

    public Dictionary_DLNode() {
        this(new EqualityTesterDeafult());
    }

    public Dictionary_DLNode(IEqualityTester t) {
        L= new List_DLNode();
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
    public IEntry find(Object key) {
        IIterator p = L.positions();
        while (p.hasNext()){
            IPosition pos = (IPosition) p.getNext();
            IEntry entry = (IEntry) pos.getElem();
            if(T.isEqualTo(entry.getKey(), key)){
                return entry;
            }
        }
        return null;
    }

    @Override
    public IIterator findAll(Object key) {
        IList list = new List_DLNode();
        IIterator p = L.positions();
        while (p.hasNext()){
            IPosition pos = (IPosition) p.getNext();
            IEntry entry = (IEntry) pos.getElem();
            if(T.isEqualTo(entry.getKey(), key)){
                list.insertLast(entry);
            }
        }
        return new IteratorElement(list);
    }

    @Override
    public IEntry insert(Object key, Object value) {
        IEntry entry = new EntryDefault(key,value);
        L.insertFirst(entry);
        return entry;
    }

    @Override
    public IEntry remove(Object key) {
        IIterator p = L.positions();
        while (p.hasNext()){
            IPosition pos = (IPosition) p.getNext();
            IEntry entry = (IEntry) pos.getElem();
            if(T.isEqualTo(entry.getKey(), key)){
                IEntry oldEntry = entry;
                L.remove(pos);
                return oldEntry;
            }
        }
        return null;
    }

    @Override
    public IIterator entries() {
        return new IteratorElement(L);
    }
}
