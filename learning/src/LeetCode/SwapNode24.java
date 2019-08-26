package LeetCode;

/**
 * Created by aiya on 2019/8/13 下午6:07
 */
public class SwapNode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null){
            //下一个要交换的头结点的pre
            ListNode tmp = pre.next.next;

            pre.next.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;

            pre = tmp.next;
        }
        return  dummy.next;
    }
}
