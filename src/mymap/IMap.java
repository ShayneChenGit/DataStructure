package mymap;

import common.IIterator;

public interface IMap {
    int getSize();

    boolean isEmpty();

    Object get(Object key);

    Object put(Object key, Object value);

    Object remove(Object key);

    IIterator entries();
}
