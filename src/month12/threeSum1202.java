package month12;


import java.util.*;

public class threeSum1202 {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public void test() {
        /**
         * 借用两数之和的思想，
         * 1、暴力求解，遍历两次
         * 2、利用hash的方法，用空间换时间
         */
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = twoSum(nums);
//        Set<Set<Integer>> sets = twoSum2(nums);
//        System.out.println(lists);
//        System.out.println(sets);

//        List<List<Integer>> lists1 = threeSum(nums);
        List<List<Integer>> lists2 = threeSum2(nums);
        System.out.println(lists2);
    }



    public  List<List<Integer>> twoSum(int[] nums) {
        //暴力
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                if (nums[i] + nums[j] == 0) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public  Set<Set<Integer>> twoSum2(int[] nums) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        Set<Set<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            Set<Integer> list = new HashSet<>();
            if (hashtable.containsKey(-nums[i])) {
                list.add(nums[i]);
                list.add(-nums[i]);
                result.add(list);
            }
            result.add(list);
            hashtable.put(nums[i], -nums[i]);
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //暴力解法，三层循环,需要去重
        //[[-1,0,1],[-1,2,-1],[0,1,-1]]
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int m = j+1; m <nums.length; m++) {
                    List<Integer> list = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[m] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }


    /**
     *     作者：guanpengchn
     *                     链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     *                     来源：力扣（LeetCode）
     *                     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        //快慢指针法，排序+双指针
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i <nums.length-2; i++) {

            //写的漂亮哇，提高效率
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重


            int head = i+1;
            int tail = nums.length-1;
            while (head < tail) {
                int sum = nums[head] + nums[tail] + nums[i];
                if (sum == 0) {
                    List<Integer> integers = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(integers);
                    //在一次提高效率
                    while (head < tail && nums[head] == nums[head+1]) head++; // 去重
                    while (head < tail && nums[tail] == nums[tail-1]) tail--; // 去重
                    head++;
                    tail--;


                } else if (sum < 0) {
                    head++;
                } else {
                    tail--;
                }

            }
        }
        return new ArrayList<>(result);
    }


    public static List<List<Integer>> threeSum3(int[] nums) {
        //hash法,思想与2数和一样，但是去重太麻烦
        return null;


    }

}
