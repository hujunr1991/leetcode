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
public class Problem400408 {


    public static void main(String[] args) {
        int[] array={2,4,3,6,3,2,5,5};
        Problem400408 p=new Problem400408();
        p.findNumsAppearOnce(array);
    }

    private void findNumsAppearOnce(int[] array) {
        if(array == null) {
            return;
        }
        int number=0;
        //所有的数组异或求出数字
        for(int i:array)
            number^=i;
        //找出这个数字在第几位
        int index=findFirstBitIs1(number);
        int number1=0;
        int number2=0;
        for(int i:array){
            if(isBit1(i,index))
                number1^=i;
            else
                number2^=i;
        }
        System.out.println(number1);
        System.out.println(number2);
    }

    private int findFirstBitIs1(int number) {

        int indexBit=0;
        while((number&1)==0){
            number=number>>1;
            ++indexBit;
        }
        return indexBit;
    }

    /**
     * 对找出这个数字在第几位进行分组操作--见剑指offer讲解
     * @param number
     * @param index
     * @return
     */
    private boolean isBit1(int number, int index) {
        number=number>>index;
        return (number&1)==0;
    }

}
