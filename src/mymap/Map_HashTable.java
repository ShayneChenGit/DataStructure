package mymap;

import common.IIterator;
import myList.IList;
import common.IteratorElement;
import myList.List_DLNode;

public class Map_HashTable implements IMap{
    private IMap[] A; //桶数组，每个桶是基于列表实现的映射结构
    private int N;
    private final double maxLambda = 0.75;
    private int size;
    private IEqualityTester T;

    public Map_HashTable() {
        this(0, new EqualityTesterDeafult());
    }

    public Map_HashTable(int n, IEqualityTester t) {
        T = t;
        N=p(n);
        A= new IMap[N];
        for(int i=0; i<N; i++){
            A[i] = new Map_DLNode(T);
        }
    }

    // 取不小于n的最小素数
    private static int p(int n){
        if(n<3){
            n=3;
        }
        n = n | 1;
        while(!prime(n)){
            n+=2;
        }
        return n;
    }

    // 判断n是否为素数
    private static boolean prime(int n){
        for(int i=3; i<1+Math.sqrt(n); i++){
            if(n/i*i == n){
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
        return 0==size;
    }

    @Override
    public Object get(Object key) {
        return A[h(key)].get(key);
    }

    // 散列定址函数（模余法）
    private int h(Object key){
        return key.hashCode() % N;
    }

    @Override
    public Object put(Object key, Object value) {
        Object oldValue=A[h(key)].put(key, value);
        if(null == oldValue){
            size++;
            if(size > N*maxLambda){ //若装填因子过大，则重散列
                rehash();
            }
        }
        return oldValue;
    }
    //重散列
    private void rehash(){
        IIterator it = this.entries();
        N = p(N<<1); //桶容量至少加倍
        A = new IMap[N];
        for(int i=0; i<N; i++){
            A[i] = new Map_DLNode(T);
        }
        while(it.hasNext()){
            IEntry e = (IEntry) it.getNext();
            Object k = e.getKey();
            Object v = e.getValue();
            A[h(k)].put(k, v);
        }
    }

    @Override
    public Object remove(Object key) {
        Object oldValue = A[h(key)].remove(key);
        if(null != oldValue){
            size--;
        }
        return oldValue;
    }

    @Override
    public IIterator entries() {
        IList L =new List_DLNode();
        for(int i=0; i<N; i++){
            IIterator it = A[i].entries();
            while (it.hasNext()){
                L.insertLast(it.getNext());
            }
        }
        return new IteratorElement(L);
    }
}
