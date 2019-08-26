package LeetCode;

import java.util.List;

/**
 * Created by aiya on 2019/8/13 下午7:54
 * K个一组翻转链表：一个分段，一个翻转
 * 两个函数
 */
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
        dummy.next = head;
        for (int i = 1; cur != null; ++i){
            if (i % k == 0){
                //pre.next是
                reverseOne(pre, cur.next);
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    public ListNode reverseOne(ListNode pre, ListNode next){
return null;
    }
}
