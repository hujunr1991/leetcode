package month12;

public class Numerof11223 {


    /**
     * 剑指offer面试题10----输入9，对应的二进制为1001，则数据1的个数为2
     * 思路一：依次右移动和1想与判断是否为为1，是则加1，缺点是对于负数湖造成死循环
     */
    public static void Numerof1One(int n) {
        int count = 0;
        //结束条件是n不等于0
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
    }

    /**
     * 思路二：移动flag，比如1001110依次和每一位比较，这样对有32证书需要做多比较32次
     *
     * @param n
     */
    public static void Numerof1Two(int n) {
        int count = 0;
        int flag = 1;
        //结束条件是n不等于0
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
    }


    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0
     *
     */
    public static void Numerof1Three(int n) {
        int count = 0;
        //结束条件是n不等于0
        while (n != 0) {
            count++;
            n = (n-1) & n;
        }
    }

    public static void main(String[] args) {

    }
}
