package month2101;

public class Problem270109 {

    public TreeNode preNode = null;
    public TreeNode newHead = null;

    /**
     * 二叉搜索树与双向链表
     * 我是没看懂，借鉴解法如下：
     * 1、中序遍历（LDR）对二叉搜索树进行遍历，并将整个节点存储到TreeNode*类型的vector容器中
     * 2、遍历vector容器利用节点的left、right指针进行双向链表的连接
     *
     *
     * 在遍历的迭代逻辑中，我们要将前次迭代和本次迭代处理的节点，按照双向链表的要求进行处理。怎么处理尼？
     * 通过一个全局变量保存上次遍历的节点，然后再本次遍历的节点处理中进行如下操作：
     *
     * preNode.right  = curNode;
     *
     * curNode.left = preNode;
     */
    public TreeNode treeToDoublyList(TreeNode root) {


        if (root == null) {
            return root;
        }

        middleOrder(root);
        //将处理后的双向链表的首尾相连
        newHead.left = preNode;
        preNode.right = newHead;
        return newHead;

    }

    //算法思路：因为二叉排序树的中序遍历的输出就是有序的列表，
    //我们改写中序遍历，通过定义一个preNode的全局变量保留当前节点的前一个节点。
    //preNode.right = curNode,curNode.left = preNode.
    private void middleOrder(TreeNode root) {
        //如果当前节点为null，则return null
        if(root == null){
            return ;
        }
        //中序遍历,
        middleOrder(root.left);
        //中序遍历，第一个遍历的节点就是最左下的最小节点。
        //即第一个访问的节点就为左下角节点。
        //如果出preNode，则指向此时root，即为最左下节点。用来第一次遍历时，初始化
        //第一次进入这里是最左子节点时，初始化所需节点指引。
        if(preNode == null){
            newHead = root;
            preNode = root;
        }//否则，
        else{
            //以preNode始终指向前一个节点，正好是比当前节点小的节点，
            //进行以下操作，将其转成双向链表。
            preNode.right = root;
            root.left = preNode;
            preNode = root;
        }
        middleOrder(root.right);
    }


}
