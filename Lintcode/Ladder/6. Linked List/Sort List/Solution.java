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
     * @return: You should return the head of the sorted linked list,
     *               using constant space complexity.
     */
     
    // 此為merge sort的解法，用到了三個函式，
    // findMid : 找List的中間點
    // merge : 合併兩個list
    // mergeSort : 不斷的recursive 把list切兩半
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null) {
            return null;
        }

        return mergeSort(head);
    }
    
    // 找中間點，用fast與slow兩個pointer，等fast等於null時，代表slow已到middle。
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        //記得檢查fast也不為空，否則程式會有錯誤
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //記得用個dummy node
    private  ListNode merge(ListNode listOne, ListNode listTwo) {
        if (listOne == null) {
            return listTwo;
        }
        if (listTwo == null) {
            return listOne;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (listOne != null && listTwo != null) {
            if (listOne.val < listTwo.val) {
                tail.next = listOne;
                listOne = listOne.next;
            } else {
                tail.next = listTwo;
                listTwo = listTwo.next;
            }
            tail = tail.next;
        }
        
        if (listOne != null) {
            tail.next = listOne;
        } else {
            tail.next = listTwo;
        }
        
        return dummy.next;
    }
    
    
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMid(head);
        ListNode right = mergeSort(middle.next);
        
        //記得把middle後面那個點切掉，否則會連後面的點一起處理了。
        middle.next = null;
        ListNode left = mergeSort(head);
        
        return merge(left, right);
    }
}