package mydictionary;

import common.IIterator;
import mymap.IEntry;

public interface IDictionary {
    int getSize();

    boolean isEmpty();

    IEntry find(Object key);

    //返回由关键码为key的条目组成的迭代器
    IIterator findAll(Object key);

    IEntry insert(Object key, Object value);

    IEntry remove(Object key);

    //返回词典中所有条目的一个迭代器
    IIterator entries();
}
