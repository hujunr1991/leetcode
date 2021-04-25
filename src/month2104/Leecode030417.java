package month2104;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 */
public class Leecode030417 {


    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        Leecode030417 leecode020417 = new Leecode030417();
        int[] coins = {1, 2, 5};
        res = leecode020417.permute(coins);
        System.out.println(res);
    }

    private List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }


    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进⼊下⼀层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }

    }

}
