package mydictionary;

import common.IIterator;
import common.IteratorElement;
import myList.IList;
import myList.List_DLNode;
import mymap.EqualityTesterDeafult;
import mymap.IEntry;
import mymap.IEqualityTester;

/**
 * 基于散列表实现的（无序）词典结构
 */
public class Dictionary_HashTable implements IDictionary {

    private IDictionary[] A;
    private int N;
    private final double maxLambda = 0.75;
    private int size;
    private IEqualityTester T;

    public Dictionary_HashTable() {
        this(0, new EqualityTesterDeafult());
    }

    public Dictionary_HashTable(int n, IEqualityTester t) {
        T = t;
        N = p(n);
        A = new IDictionary[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Dictionary_DLNode(T);
        }
        size = 0;
    }

    // 取不小于n的最小素数
    private static int p(int n) {
        if (n < 3) {
            n = 3;
        }
        n = n | 1;
        while (!prime(n)) {
            n += 2;
        }
        return n;
    }

    // 判断n是否为素数
    private static boolean prime(int n) {
        for (int i = 3; i < 1 + Math.sqrt(n); i++) {
            if (n / i * i == n) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    private int h(Object key) {
        return key.hashCode() % N;
    }

    @Override
    public IEntry find(Object key) {
        return A[h(key)].find(key);
    }

    @Override
    public IIterator findAll(Object key) {
        return A[h(key)].findAll(key);
    }

    @Override
    public IEntry insert(Object key, Object value) {
        IEntry entry = A[h(key)].insert(key, value);
        size++;
        if (size > N * maxLambda) {
            rehash();
        }
        return entry;
    }

    @Override
    public IEntry remove(Object key) {
        IEntry oldEntry = A[h(key)].remove(key);
        if (null != oldEntry) {
            size--;
        }
        return oldEntry;
    }

    @Override
    public IIterator entries() {
        IList L = new List_DLNode();
        for (int i = 0; i < N; i++) {
            IIterator it = A[i].entries();
            while (it.hasNext()) {
                L.insertLast(it.getNext());
            }
        }
        return new IteratorElement(L);
    }

    //重散列
    private void rehash() {
        IIterator it = this.entries();
        N = p(N << 1);
        A = new IDictionary[N];//桶数组容量至少加倍
        for (int i = 0; i < N; i++) A[i] = new Dictionary_DLNode(T);//为每个桶分配一个子词典
        while (it.hasNext()) {//将其对应的词典结构中的
            IEntry e = (IEntry) it.getNext();//各条目逐一取出，将其
            Object k = e.getKey();//关键码和
            Object v = e.getValue();//数据对象
            A[h(k)].insert(k, v);//整合为新的条目，插入对应的子词典中
        }
    }
}
