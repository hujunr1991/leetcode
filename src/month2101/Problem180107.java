package month2101;

public class Problem180107 {

    /**
     * 剑指offer18----判断是否为子树
     *
     *
     * 递归的思想，把问题简单化，假设A喝B就是相等的树，在扩展，
     * 递归结束的条件是当任意一个树为空的时候
     *
     */


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;

        //当root1和root2都不为null的时候，才进行比较。否则直接返回false
        if(root1 != null && root2 != null) {
            //如果找到了对应root2的根节点的点
            if(root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含root2
                result = DoesTreeHaveTree2(root1, root2);
            }

            if(!result) {
                //如果找不到，那么就再去root1的左儿子当作起点，去判断时候包含root2
                result = HasSubtree(root1.left, root2);
            }

            if(!result) {
                //如果还找不到，那么就再去root1的右儿子当作起点，去判断时候包含root2
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }


    public boolean DoesTreeHaveTree2(TreeNode node1, TreeNode node2) {

        //如果node2已经遍历完了都能对应的上，返回true
        if(node2 == null) {
            return true;
        }

        //如果node2还没有遍历完，node1却遍历完了。返回false
        if(node1 == null) {
            return false;
        }

        //如果其中有一个点没有对应上，返回false
        if(node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return DoesTreeHaveTree2(node1.left, node2.left) && DoesTreeHaveTree2(node1.right, node2.right);

    }
}
