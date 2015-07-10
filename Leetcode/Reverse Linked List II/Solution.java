/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode preM = head;
        ListNode mNode = head.next;
        
        ListNode nNode = mNode;
        ListNode postN = mNode.next;
        
        for (int i = m; i < n; i++) {
            if (mNode == null) {
                return null;
            }
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        
        preM.next = nNode;
        mNode.next = postN;
        
        return dummy.next;
    }
}