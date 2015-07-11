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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        //建左右兩個dummy分別存下小於x與大於x的節點。
        //接著用left 與right這兩個點去跑，原本的dummy用來記錄起始位置
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        //接著使用head來traverse整個list
        //若比x小則放在左list，其於放在右list
        //別忘了要順便移動left與right pointer
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        //記得把right的next設為null，因原本可能不為null
        //再把左右兩個list接起來，回傳。
        right.next = null;
        left.next = rightDummy.next;
        
        return leftDummy.next;
    }
}

