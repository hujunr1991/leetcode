package month2104;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 40：数组中只出现一次的数字,难点在：要求时间复杂度是 O（n），空间复杂度为 O（1）；
 *
 * 突破点：任何一个数字异或自己为0
 * 解题思路：
 *
 */
public class Problem410409 {


    public static void main(String[] args) {
        int[] array={1,2,4,7,11,15};
        Problem410409 p=new Problem410409();
        List<List<Integer>> numsSum = p.findNumsSum(array, 15);
        System.out.println(numsSum);

    }

    private List<List<Integer>> findNumsSum(int[] array, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        int start = 0;
        int end =array.length -1;
        for (int i = start; i < end; i++) {
            if (array[i] + array[end] < n) {
                start++;
            } else if (array[i] + array[end] > n){
                end--;
            } else {
                sumList.add(array[i]);
                sumList.add(array[end]);
                list.add(sumList);
            }
        }
        return list;
    }


    public void findContinuesSequence(int sum) {
        if (sum < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                printContineNum(small, big);
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum)
                    printContineNum(small, big);
            }
            big++;
            curSum += big;
        }
    }

    private void printContineNum(int small, int big) {
        for(int i=small;i<=big;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
