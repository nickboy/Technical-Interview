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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        if (head == null || n == 0) {
            return null;
        }
        // 用兩個pointer，讓fast先走個n步，
        // 接下來slow與fast相同速度移動
        // 當fast走到底時，回傳slow即可
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

