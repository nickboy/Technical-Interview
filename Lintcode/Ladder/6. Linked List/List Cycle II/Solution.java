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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        if (head == null || head.next == null) {
            return null;
        }
        
        // 使用快慢指針來作這題，如果兩者有相遇的話，必定有cycle，
        // 一但相同的話，改為相同速度來走，若遇到一樣，則該點為cycle的起始點
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 需要找到為何是檢查slow.next
        while (slow.next != head) {
            slow = slow.next;
            head = head.next;
        }
        
        return head;
    }
}

