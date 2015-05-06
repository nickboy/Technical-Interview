/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode current = head;
        ListNode temp = null;
        while(current != null){
            temp = dummy;
            dummy = current;
            current = current.next;
            dummy.next = temp;
        }
        return dummy;
    }
}