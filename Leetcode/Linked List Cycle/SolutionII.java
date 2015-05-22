/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SolutionII {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                break;
        }
        
        if(fast == null || fast.next == null) {
            return null;
        }
        
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}