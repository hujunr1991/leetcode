package month05;

import java.util.Arrays;

public class removeDuplicates26_1 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        /**
         *    // 题目已经说了一个排好序的，所以只需要用比较前后连个元素是否一样就
         *    可以，可以认为时双指针法，我们可以放置两个指针 ii 和 jj，其中 ii
         *    是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]，我们就增加 j
         *    以跳过重复项。
         */
        int i = 0;//慢指针
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                /**
                 * 思想: int[] nums = {1,2,2,3,4,4,5};
                 * 判断快指针和慢指针的数是否相等，相等跳过，此时慢指针不动，快指针加1，
                 * 当出现不相等的时候，慢指针加1（i先加1很关键），然后覆盖相同的值
                 * 需要注意的是没有出现相同的时候i++后赋值时操作是：nums[1] = nums[1],
                 * 同等赋值
                 *
                 */
                i++;
                //分为两种情况，（1）两个数相等直接跳过，J走一步，下一次不相等就用后面的数覆盖前面的数，如果不相等，i走一步，总体的思路时J一定会走一步，如果不相等I才走一步，这样就去除了重复元素
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, i + 1)));
        System.out.println(i + 1);
        //i从0开始，则最后要有i+1
        return i + 1;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 5};
        removeDuplicates(nums);

        long startTime = System.nanoTime();
        System.out.println(startTime);
    }
}
