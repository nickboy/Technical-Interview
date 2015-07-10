/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null || head.next == null) {
            return head;
        } 
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }  
}
