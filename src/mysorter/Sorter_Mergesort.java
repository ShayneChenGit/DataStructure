package mysorter;

import mysequence.ISequence;

public class Sorter_Mergesort implements ISorter{
    private IComparator C;

    public Sorter_Mergesort() {
        this(new ComparatorDefault());
    }

    public Sorter_Mergesort(IComparator c) {
        this.C = c;
    }

    @Override
    public void sort(ISequence s) {

    }
}
