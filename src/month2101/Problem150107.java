package month2101;

public class Problem150107 {

    /**
     * 面试题15----链表中倒数第K个节点
     */

    public ListNode FindKthToTail_2(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode node1 = head, node2 = head;
        for (int i = 0; i < (k - 1); i++) {
            if(node1.next != null) {
                node1 = node1.next;
            }
            else return null;
        }

        while(node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;

    }

}
