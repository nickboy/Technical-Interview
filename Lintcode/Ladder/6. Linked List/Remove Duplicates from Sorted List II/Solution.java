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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        
        //建一個dummy且指向head，接著把head移到dummy的位置，
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        //不斷的比較下一個與下下個
        while (head.next != null && head.next.next != null) {
            //若一樣時，先把值記下來，接著去比較值，若一樣的話，不斷的去移動head的pointer
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                //終於找到不一樣的了，則移動head去處理下一個
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}

