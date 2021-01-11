package myVector;

import myException.ExceptionBoundaryViolation;

public class Vector_Array implements IVector {
    private final int N = 1024;
    private int n = 0;
    private Object[] A;

    public Vector_Array() {
        A = new Object[N];
        n = 0;
    }


    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (0 == n ? true : false);
    }

    @Override
    public Object getAtRank(int r) {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        return A[r];
    }

    @Override
    public Object replaceAtRank(int r, Object obj) {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        Object bak = A[r];
        A[r] = obj;
        return bak;
    }

    @Override
    public Object insertAtRank(int r, Object obj) {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        if (n >= N) {
            throw new ExceptionBoundaryViolation("array overflow");
        }

        for (int i = n; i > r; i--) {
            A[i] = A[i - 1];
        }
        A[r] = obj;
        n++;
        return obj;
    }

    @Override
    public Object removeAtRank(int r) {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        Object bak = A[r];
        for (int i = r; i < n - 1; i++) {
            A[i] = A[i + 1];
        }
        n--;
        return bak;
    }
}
