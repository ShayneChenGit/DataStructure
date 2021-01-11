package chapter1;

/**
 * 计算幂函数 power(2,n)=2^n
 * 递归基：n=0, power2=1
 * 一般情况：n>0, power2(n) = 2*power2(n-1)
 * 一般情况又可分为，n为基数, power2(n) = power2(n/2向下取整)^2 * 2；n为偶数，power2(n)=power2(n/2)^2
 */
public class PowerFunction {

    public int power2(int n){
        if(n==0){
            return 1;
        }
        if((n & 1)==0){
            return (int) Math.pow(power2(n >> 1),2);
        } else {
            return (int) Math.pow(power2(n >> 1),2 )<< 1;
        }
    }

    public static void main(String[] args) {
        PowerFunction powerFunction = new PowerFunction();
        int result = powerFunction.power2(10);
        System.out.println(result);
    }
}
