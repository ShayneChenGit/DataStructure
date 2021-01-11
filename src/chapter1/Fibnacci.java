package chapter1;

public class Fibnacci {

    // 二分递归
    public long solution(int n){
        if (n<=2){
            return 1;
        } else {
            return solution(n-1) + solution(n-2);
        }
    }

    // 尾递归
    public long solution2( int n){
        return solution2(1,1,n);
    }

    public long solution2(int first, int second, int n){
        if(n==0){
            return 0;
        }
        if(n<=2){
            return 1;
        }
        if(n == 3){
            return first + second;
        }
        return solution2(second, first+second, n-1);
    }

    // 迭代，两个辅助变量
    public long solution3(int n){
        if(n==0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        int temp1 = 0;
        int temp2 = 1;
        int res = 0;
        for (int i=2; i<=n; i++){
            res = temp1 + temp2;
            temp1 = temp2;
            temp2 = res;
        }
        return res;
    }

    // 迭代，一个辅助变量
    public long solution4(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int temp = 0;
        int res = 1;
        for (int i=2; i<=n; i++){
            res = res + temp;
            temp = res - temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Fibnacci fibnacci = new Fibnacci();
        System.out.println("fib(1): " + fibnacci.solution(1));
        System.out.println("fib(2): " + fibnacci.solution(2));
        System.out.println("fib(3): " + fibnacci.solution(3));
        System.out.println("fib(4): " + fibnacci.solution(4));
        System.out.println("fib(10): " + fibnacci.solution(10));
        System.out.println("fib(10): " + fibnacci.solution2(10));
        System.out.println("fib(10): " + fibnacci.solution3(10));
        System.out.println("fib(10): " + fibnacci.solution4(10));
    }
}
