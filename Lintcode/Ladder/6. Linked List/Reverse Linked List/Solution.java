/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        // null             1-->2-->3-->4-->null
        // null<--1         2-->3-->4-->null
        // null<--1<--2     3-->4-->null
        // null<--1<--2<--3 4-->null
        // null<--1<--2<--3<--4 null
        
        //主要使用三個pointer，prev，cur，next
        //因cur.next改指針時會消失，得用next記著
        //去畫圖就能理解
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

