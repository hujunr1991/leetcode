package month2101;

public class Problem170107 {

    /**
     * 剑指offer17---合并链表
     * @param head1
     * @param head2
     * @return
     */

    public ListNode mergeList(ListNode head1,ListNode head2){
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode merge = null;
        if (head1.val < head2.val) {
            merge = head1;
            merge.next = mergeList(head1.next, head2);

        } else {
            merge = head2;
            merge.next = mergeList(head1, head2.next);
        }

        return merge;
    }
}
