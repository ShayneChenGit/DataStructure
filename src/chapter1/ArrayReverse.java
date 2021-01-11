package chapter1;

/**
 * 将数组中的各元素的次序前后翻转
 * 多递归基
 * 隐式包含low=high，low>high，两种递归基
 */
public class ArrayReverse {

    public void reverse(int[] A){
        reverse(A, 0, A.length-1);
    }
    // 递归
    private void reverse(int[] A, int low, int high){
        if(low < high){
            int tmp = A[low];
            A[low] = A[high];
            A[high] = tmp;
            reverse(A, low +1, high - 1);
        }
    }

    // 迭代
    public void reverse2(int[] A){
        reverse2(A, 0, A.length-1);
    }
    private void reverse2(int[] A, int low, int high){
        while (low < high){
            int tmp = A[low];
            A[low] = A[high];
            A[high] = tmp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] B = new int[]{0,1,2,3,4,5,6,7,8,9};

        ArrayReverse arrayReverse = new ArrayReverse();
        arrayReverse.reverse(A);

        arrayReverse.reverse2(B);

        for (int ele : A){
            System.out.print(ele + " ");
        }

        System.out.println();

        for (int ele : B){
            System.out.print(ele + " ");
        }

    }
}
