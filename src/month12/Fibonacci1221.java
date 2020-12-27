package month12;

public class Fibonacci1221 {

    /**
     * 剑指offer面试题9，递归，爬楼梯和斐波拉契问题
     */

    //效率太慢
    public static long Fibonacci1221One(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n ==1) {
            return 1;
        }

        return Fibonacci1221One(n-1) + Fibonacci1221One(n-2);
    }

    //优化措施，把每次的结果存起来
    public static long Fibonacci1221Two(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n ==1) {
            return 1;
        }
        long one = 0;
        long two = 1;
        long sum = 0;
        for (int i = 2; i <=n ;i++) {
            sum = one+ two;
            one = two;
            two = sum;

        }
        return sum;

    }

    public static void main(String[] args) {
        long l = Fibonacci1221One(5);
        long l1 = Fibonacci1221Two(5);
        System.out.println(l + "====="+ l1);
    }
}
