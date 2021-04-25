package month2104;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode111_01_0424 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 1;
        while (!queue.isEmpty()) {
            int num = queue.size();
            //因为左右节点都有，所以需要遍历
            for (int i =0; i <num; i++) {
                TreeNode cur = queue.remove();
                if (cur.left == null && cur.right == null) {
                    return deep;
                }
                if (cur.left !=null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            deep++;
        }
        return deep;
    }

}


