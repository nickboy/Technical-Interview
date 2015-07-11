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
     * @return: void
     */
    public void reorderList(ListNode head) {  
        if (head == null || head.next == null) {
            return;
        }
        
        // 1. 找出中間點
        // 2. 反轉後半段
        // 3. 把後半段斷開
        // 4。利用改寫過的merge來交插合併前半段與後半段
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    //改寫過的merge函式，以interleaving的方式來合併list
    private void merge(ListNode nodeOne, ListNode nodeTwo) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int num = 0;
        
        while(nodeOne != null && nodeTwo != null) {
            if (num % 2 == 0) {
                tail.next = nodeOne;
                nodeOne = nodeOne.next;
            } else {
                tail.next = nodeTwo;
                nodeTwo = nodeTwo.next;
            }
            tail = tail.next;
            num++;
        }
        if (nodeOne != null) {
            tail.next = nodeOne;
        } else {
            tail.next = nodeTwo;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        //四個pointer別寫錯了。
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

