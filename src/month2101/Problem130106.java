package month2101;

public class Problem130106 {

    /**
     * 剑指offer题目13，分为三种情况讨论
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode thrid = new ListNode();
        head.next = second;
        second.next = thrid;
        head.val = 1;
        second.val = 2;
        thrid.val = 3;
        Problem130106 problem130106 = new Problem130106();
        problem130106.delectNode(head, second);
        System.out.println(head.next.val);
    }

    private void delectNode(ListNode head, ListNode delet) {
        if (head == null || delet == null) {
            return;
        }
        //删除为头节点
        if (head == delet) {
            head = null;
        } else {
            //删除为尾节点
            if (delet.next == null) {
                ListNode endList = head;
                while (endList.next.next != null ) {
                    endList = endList.next;
                }
                endList.next = null;
            } else {
                //删除为中间
                delet.val = delet.next.val;
                delet.next = delet.next.next;
            }
        }
    }


}

class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
