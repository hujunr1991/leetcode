package month2104;

/**
 * 两个链表的第一个公共点----首先两个列表必须是有公共的节点的，问题是从哪里开始他们相交
 */
public class Problem370407 {

    public static void main(String[] args) {
        ListNode head1=new ListNode();
        ListNode second1=new ListNode();
        ListNode third1=new ListNode();
        ListNode forth1=new ListNode();
        ListNode fifth1=new ListNode();
        ListNode head2=new ListNode();
        ListNode second2=new ListNode();
        ListNode third2=new ListNode();
        ListNode forth2=new ListNode();
        head1.nextNode=second1;
        second1.nextNode=third1;
        third1.nextNode=forth1;
        forth1.nextNode=fifth1;
        head2.nextNode=second2;
        second2.nextNode=forth1;
        third2.nextNode=fifth1;
        head1.data=1;
        second1.data=2;
        third1.data=3;
        forth1.data=6;
        fifth1.data=7;
        head2.data=4;
        second2.data=5;third2.data=6;
        forth2.data=7;
        Problem370407 test=new Problem370407();
        System.out.println(test.findFirstCommonNode(head1, head2).data);
    }

    private ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int len1=getListLength(head1);
        int len2=getListLength(head2);
        ListNode longListNode=null;
        ListNode shortListNode=null;
        int dif=0;
        if(len1>len2){
            longListNode=head1;
            shortListNode=head2;
            dif=len1-len2;
        }else{
            longListNode=head2;
            shortListNode=head1;
            dif=len2-len1;
        }
        for(int i=0;i<dif;i++){
            longListNode=longListNode.nextNode;
        }
        while(longListNode!=null&&shortListNode!=null
                &&longListNode!=shortListNode){
            longListNode=longListNode.nextNode;
            shortListNode=shortListNode.nextNode;
        }
        return longListNode;
    }

    private int getListLength(ListNode head1) {
        int result=0;
        if(head1==null)
            return result;
        ListNode point=head1;
        while(point!=null){
            point=point.nextNode;
            result++;
        }
        return result;
    }
}

class ListNode{

    ListNode nextNode;
    int data;
}
