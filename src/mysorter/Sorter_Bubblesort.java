package mysorter;

import mysequence.ISequence;

public class Sorter_Bubblesort implements ISorter {
    private IComparator C;

    public Sorter_Bubblesort() {
        this(new ComparatorDefault());
    }

    public Sorter_Bubblesort(IComparator c) {
        this.C = c;
    }

    @Override
    public void sort(ISequence S) {
        int n = S.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (0 < C.compare(S.getAtRank(j), S.getAtRank(j + 1))) {
                    Object temp = S.getAtRank(j);
                    S.replaceAtRank(j, S.getAtRank(j + 1));
                    S.replaceAtRank(j + 1, temp);
                }
            }
        }
    }
}
