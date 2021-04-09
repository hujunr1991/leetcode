package month2104;

/**
 * 二叉树的最大深度
 */
public class Problem390408 {


    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode();
        BinaryTreeNode node1=new BinaryTreeNode();
        BinaryTreeNode node2=new BinaryTreeNode();
        BinaryTreeNode node3=new BinaryTreeNode();
        BinaryTreeNode node4=new BinaryTreeNode();
        BinaryTreeNode node5=new BinaryTreeNode();
        BinaryTreeNode node6=new BinaryTreeNode();
        root.leftNode=node1;
        root.rightNode=node2;
        node1.leftNode=node3;
        node1.rightNode=node4;
        node2.rightNode=node5;
        node4.leftNode=node6;
        root.value=1;
        node1.value=2;
        node2.value=3;
        node3.value=4;
        node4.value=5;
        node5.value=6;
        node6.value=7;
        Problem390408 p=new Problem390408();
        System.out.println(p.treeDepth(root));
    }

    private int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left=treeDepth(root.leftNode);
        int right=treeDepth(root.rightNode);
        return (left>right)?left+1:right+1;
    }

    public boolean isBalanced(BinaryTreeNode root){
        int depth=0;
        return isBalanced(root,depth);
    }
    private boolean isBalanced(BinaryTreeNode root, int depth) {
        if(root==null){
            depth=0;
            return true;
        }
        int left=0,right=0;
        if(isBalanced(root.leftNode,left)&&isBalanced(root.rightNode, right)){
            int diff=left-right;
            if(diff<=1&&diff>=-1){
                depth=1+(left>right?left:right);
                return true;
            }
        }
        return false;
    }
}




class BinaryTreeNode{
    BinaryTreeNode leftNode;

    BinaryTreeNode rightNode;

    int value;
}