/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode beforeStart = null;
        ListNode afterStart = null;
        ListNode beforeEnd = null;
        ListNode afterEnd = null;
        
        while (head != null) {
            //remember the next element, important!!!
            ListNode next = head.next;
            head.next = null;
            
            int val = head.val;
            if(val < x) {
                if(beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if(afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = head;
                    afterEnd = afterEnd.next;
                }
            }
            head = next;
        }
        
        if (beforeStart == null)
            return afterStart;
        
        beforeEnd.next = afterStart;
        return beforeStart;
        
    }
}