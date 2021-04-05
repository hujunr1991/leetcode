package month2102;

public class Problem310216 {
    /**
     * 连续数组的最大值（不能排序）
     * 我能想到的：暴力穷举法
     * 解法一：每次相加，遇到前面数字和后面的数加起来还小可以舍弃前面的数
     *
     */


    //穷举法
    public static void main(String[] args) {
        Problem310216 p=new Problem310216();
        int[] array={1,-2,3,10,-4,7,2,-5};
        System.out.println(p.findGreatestSubArray(array));
    }

    private int findGreatestSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int sum = 0;
        int greaterSum = 0;

        for (int i = 0; i <array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum+= array[i];
            }

            if (sum > greaterSum) {
                greaterSum = sum;
            }

        }
        return greaterSum;

    }
}
