package month05;

import java.util.Arrays;

public class removeDuplicates80_2 {

    public static int removeDuplicates(int[] nums) {
//        int i = 0;
//        for (int j = 2; j < nums.length-1; j++) {
//            if (nums[i] != nums[j] && nums[i] != nums[i+1]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }

        //dup为允许重复的次数
        int dup = 2;
        if(nums.length <= dup) return nums.length;
        int index = dup;
        for (int i=dup; i<nums.length;i++){

            /**
             *
             */
            if(nums[index-dup] != nums[i]){
                nums[index] =nums[i];
                index++;
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOf(nums, index)));
        System.out.println(index);
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2,3, 3, 4, 4, 4, 5};
        removeDuplicates(nums);
    }
}
