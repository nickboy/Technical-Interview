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
        if (m >= n || head == null) {
            return head;
        }
        
        //因有可能head會變，建一個dummy 來記住head，最後return dummy.next
        ListNode dummy = new ListNode(0);
        

        //從dummy開始走m-1步來找m的前一個點
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        
        //這個部份跟part 1是一樣的，但不需額外的dummy，設定兩個pointer來記錄m node與m node下一個。
        ListNode nNode = mNode;
        ListNode postN = mNode.next;
        
        for (int i = m; i < n; i++) {
            if (postN == null) {
                return null;
            }
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        
        //把點接起來，畫圖即能理解
        prevM.next = nNode;
        mNode.next = postN;
        
        return dummy.next;
    }
}
