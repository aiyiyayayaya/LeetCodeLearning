package LeetCode;

/**
 * Created by aiya on 2019/7/31 上午9:41
 * 待完成。。
 */
public class MergeKList23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        int n = lists.length;
        while(n > 1){
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++){
                merge(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }
    //两两合并
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;
        else if (l2 != null)
            cur.next = l2;
        return dummy.next;
    }
}
