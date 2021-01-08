package month2101;

import java.util.Arrays;

public class Problem140106 {
    /**
     * 调整数组让奇数位于偶数前面---剑指offer题目14
     * 思路：两指针法
     */
    public int[] recorderOddEven(int[] data, int length) {
        if (data == null && length <= 0) {
            return null;
        }

        int begin = 0;
        int end = length - 1;

        // begin指针要位于end指针前面
        while (begin < end) {
            // 向后移动begin指针，直到它指向偶数
            if (begin < end && !isEven(data[begin])) {
                begin++;
            }

            // 向前移动end指针，直到它指向奇数
            if (begin < end && isEven(data[end])) {
                end--;
            }

            // 交换奇数和偶数的位置
            if (begin < end) {
                int temp = data[begin];
                data[begin] = data[end];
                data[end] = temp;
            }
        }
        return data;
    }

    // 扩展函数
    private boolean isEven(int data) {
        return (data & 0x1) == 0;
    }

    // 测试
    public static void main(String[] args) {
        Problem140106 obe = new Problem140106();
        int[] arr = {1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10};
        int[] data = obe.recorderOddEven(arr, arr.length);
        System.out.println(Arrays.toString(data));
    }


}
