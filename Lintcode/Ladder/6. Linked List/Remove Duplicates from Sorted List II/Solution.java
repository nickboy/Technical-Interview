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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        
        if (head == null) {
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
        
        ListNode mNode = head.next;
        ListNode preM = head;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        for (int i = 1; i <= n - m; i++) {
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
