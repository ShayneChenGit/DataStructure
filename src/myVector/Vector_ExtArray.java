package myVector;

import myException.ExceptionBoundaryViolation;

public class Vector_ExtArray implements IVector {

    private int N = 8;
    private int n;
    private Object[] A;

    public Vector_ExtArray() {
        A = new Object[N];
        n = 0;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (0 == n) ? true : false;
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        return A[r];
    }

    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        Object bak = A[r];
        A[r] = obj;
        return bak;
    }

    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("rank out of bound");
        }
        if (N <= n) {
            N *= 2;
            Object[] B = new Object[N];
            for (int i = 0; i < n; i++) {
                B[i] = A[i];
            }
        }

        for (int i = n; i > r; i--) {
            A[i] = A[i - 1];
        }
        A[r] = obj;
        n++;
        return obj;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
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
