package LeetCode;

/**
 * Created by aiya on 2019/7/15 上午10:25
 * 给一个链表，每K个一组翻转链表，K<=链表长度
 * 如果节点总数不是K的整数倍，将最后剩余的节点保持原顺序
 */
public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy,pre = dummy;
        int len = 0;
        //get the length of list
        while(cur.next != null) {
            ++len;
            cur = cur.next;
        }
        //if the rest node >= K, meaning the there still have a group can be reverse
        while (len >= k){
            cur = pre.next;
            for (int i = 1; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            len -= k;
        }
        return dummy.next;
    }
}
