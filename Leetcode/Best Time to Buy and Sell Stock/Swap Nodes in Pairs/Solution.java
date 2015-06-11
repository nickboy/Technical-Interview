/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } 
        // use dummy now to remember the head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // use previous and current nodes to handle the swapping
        ListNode previous = dummy;
        ListNode current = head;
        
        while (current != null && current.next != null) {
            // use next node to remember next swap start point.
            ListNode next = current.next.next;
            current.next.next = current;
            previous.next = current.next;
            current.next = next;
            previous = current;
            current = next;
        }
        
        return dummy.next;
    }
}