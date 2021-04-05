package month2102;

public class Problem320227 {

    /**
     * 从 1 到 n 整数中 1 出现的次数
     * 解法一：对每个数进行除10操作，最后为个位为1
     *
     * 方法二，分析1出现的规律，从1，13，23开始分析，得出的结论是：分为三种情况
     * 1、如果百位上的数字为 0，则百位上出现 1 的次数仅由更高位决定，比如 12013，等于更高位数字乘以当前位数，即 12 * 100
     * 2、如果百位上的数字大于 1，则百位上出现 1 的次数仅由更高位决定，比如 12213，即（12 + 1） *100
     * 3、如果百位上的数字为 1，则百位上出现 1 的次数不仅受更高位影响，还受低位影响，例如 12113，12*100+114（出现 1 的情况是 12100~12113，
     * 共 114 个，等于低位数字 113+1。）
     *
     */

    //方法一
    private static int numberAnd1(int n) {
        int num = 0;
        for (int i =0; i<= n; i++) {
            num = num + numContains1(i);
        }
        return num;
    }

    //统计的是1出现的次数，包含其他位
    private static int numContains1(int i) {
        int sum = 0;
        while (i != 0) {
            if (i % 10 == 1) {
                sum = sum +1;
            }
            i = i/10;
        }
        return sum;
    }

    private static long counrOne(long n){
        long count = 0;
        long i = 1;
        long current = 0,after = 0,before = 0;
        while ( n/i != 0 ) {
            current = (n / i) % 10; //当前位数字
            before = n / (i * 10); //高位数字
            after = n - (n / i) * i; //低位数字
            if (current > 1)
                count = count + (before + 1) * i;
            else if (current == 0)
                count = count + before * i;
            else if(current == 1)
                count = count + before * i + after + 1;
            i = i * 10;
        }
        return count;

    }

    public static void main(String[] args) {
        int i = numberAnd1(121);
        System.out.println(i);
        long l = counrOne(121);
        System.out.println(l);
    }
}
