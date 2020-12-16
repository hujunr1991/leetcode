package month07;


public class removeDuplicates0701 {

    public static void main(String[] args) {
        int[] nums = {1,1, 2, 2, 2, 3};
//        int i = removeDuplicatesTest(nums);
//        System.out.println("新的数组长度是：" + i);
        int i = removeDuplicatesForTwo(nums);
        System.out.println("删除至多2个后的元素是:" + i);

    }

    private static int removeDuplicatesTest(int[] nums) {
        //慢指针i
        int i = 0;
        for (int j =1 ; j< nums.length; j++) {
            //不相等
            if (nums[i] != nums[j]) {
                //j+1, i+1
                i++;
                //不相等的时候用后一个元素覆盖慢指针的元素，这里面有个逻辑是当i和j的
                //位置差超过1，说明出现了相同的元素，i提前加1
                nums[i] = nums[j];
            }
        }

        return i+1;
    }


    private static int removeDuplicatesForTwo(int[] nums) {
        int dup = 2;
        if (nums.length <dup) {
            return nums.length;
        }
        int index = dup;
        for (int i = dup; i< nums.length; i++) {

            if (nums[index-dup] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }

        }

        return index;
    }

}
