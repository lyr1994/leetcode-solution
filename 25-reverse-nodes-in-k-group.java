/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int idx = 1;
        while (head != null) {
            if (idx % k == 0) {
                prev = reverse(prev, head.next);
                head = prev.next;
            } else {
                head = head.next;
            }
            idx++;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = last.next;
        }
        return last;
    }
}
