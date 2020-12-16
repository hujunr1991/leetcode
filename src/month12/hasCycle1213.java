package month12;

import java.util.HashSet;
import java.util.Set;

public class hasCycle1213 {

    /**
     * 思路一：利用空间，将每次经过的值存储起来
     * 思路儿：利用快慢指针，慢指针走一格，快指针跳二格
     * 还有几种思路：
     * 思路三：逐个删除：一个链表从头节点开始一个个删除，所谓删除就是让他的next指针指向他自己。如果没有环，
     * 从头结点一个个删除，最后肯定会删完，否正肯定会出现head=head.next；
     * 思路四：先反转在比较，如果有环，那么链表反转之后，原来的头结点和反转之后的头结点一定是同一个
     * 如果有环，那么链表反转之后，原来的头结点和反转之后的头结点一定是同一个
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;

    }

    //则快指针不管快多少，始终会在环上跑，
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head.next;
        while(true){
            if(fast != null && fast.next != null){
                fast = fast.next.next;
            }else{
                return false;
            }
            if(slow != null){
                slow = slow.next;
            }else{
                return false;
            }
            if(fast == slow){
                break;
            }
        }
        return true;
    }
}


//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
