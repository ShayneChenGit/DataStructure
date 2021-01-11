package mysorter;

public class ComparatorDefault implements IComparator{
    public ComparatorDefault() {
    }

    @Override
    public int compare(Object a, Object b) throws ClassCastException{
        return ((Comparable)a).compareTo(b);
    }
}
