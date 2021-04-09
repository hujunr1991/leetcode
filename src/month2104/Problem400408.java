package month2104;

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
        for(int i:array)
            number^=i;
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
    private boolean isBit1(int number, int index) {
        number=number>>index;
        return (number&1)==0;
    }

}
