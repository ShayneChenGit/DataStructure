package chapter1;

import java.util.ArrayList;

/**
 * 数组求和
 * 平凡情况：n=0，sum=0 （递归基）
 * 一般情况：sum(A[0,n]) = sum(A[0, n-1]) + A[n-1]
 */

public class ArraySum {

    // 线性递归
    public int sum (int A[], int n){
        if (n < 1){
            return 0;
        } else {
            return sum(A, n-1) + A[n-1];
        }

    }

    // 二分递归
    public int sum2(int A[], int low, int high){
        if(low == high){
            return A[low];
        } else {
            int mid = (low + high) >> 1;
            return sum2(A, low, mid) + sum2(A, mid, high);
        }
    }

    public static void main(String[] args) {
//        int[] A = new int[]{1,2};
        int[] A = new int[]{1,2,3,4,5,6,7,8,9};

        ArraySum arraySum = new ArraySum();
        int sum = arraySum.sum(A, A.length);
        System.out.println(sum);

        int sum2 = arraySum.sum2(A, 0, A.length-1);
        System.out.println(sum2);
    }
}
