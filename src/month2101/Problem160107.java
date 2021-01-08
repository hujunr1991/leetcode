package month2101;

public class Problem160107 {


    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head)
    {
        if (head == null)
        {
            return null;
        }

        ListNode reverseHead = null;
        // 指针1：当前节点
        ListNode currentListNode = head;
        // 指针2：当前节点的前一个节点
        ListNode prevListNode = null;

        while(currentListNode != null)
        {
            // 指针3：当前节点的后一个节点
            ListNode nextListNode = currentListNode.next;
            if(nextListNode == null)
            {
                reverseHead = currentListNode;
            }
            // 将当前节点的后一个节点指向前一个节点
            currentListNode.next = prevListNode;
            // 将前一个节点指向当前节点
            prevListNode = currentListNode;
            // 将当前节点指向后一个节点
            currentListNode = nextListNode;
        }

        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newHead = ReverseList2(node1);
        int val = newHead.val;
    }
    
}
