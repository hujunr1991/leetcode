package month2104;

import java.util.Arrays;

/**
 * 扑克牌的顺子---
 * 思路：讲数组排序，判断相隔的数字，判断大王小王的个数
 */
public class Problem440410 {

    public static void main(String[] args) {
        int[] array={0,4,6,9,0};
        Problem440410 test=new Problem440410();
        System.out.println(test.isContinuous(array));
    }

    private boolean isContinuous(int[] number) {
        if (number == null) {
            return false;
        }

        Arrays.sort(number);

        int numberZero=0;
        int numberGap=0;
        for(int i=0;i<number.length;i++){
           if (number[i] == 0) {
               numberZero++;
           } else if (i+1 < number.length) {
               //判断相邻两数是否相等，有对子直接推出
               if(number[i+1]==number[i]){
                   return false;
               }else{
                   numberGap+=number[i+1]-number[i]-1;
               }
           }
        }

        if (numberGap > numberZero) {
            return false;
        } else {
            return true;
        }


    }
}
