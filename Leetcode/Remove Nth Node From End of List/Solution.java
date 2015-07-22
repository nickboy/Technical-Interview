/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode fast = head;
        ListNode slow = head;
        dummy.next = head;
        
        for (int i = 1; i <= n; i++) {
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }
        prev.next = slow.next;
        
        return dummy.next;
    }
}