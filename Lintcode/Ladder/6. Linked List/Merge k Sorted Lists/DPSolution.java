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
public class  DPSolution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */

    // 在此用dp解法，不斷把k 個lists對半切處理，直到剩下兩個list，再call merge 2 lists的方法。
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    // 跟原本merge 2 lists的差別只在於這個對切的方法而已。
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int middle = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, middle);
        ListNode right = mergeHelper(lists, middle+1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        return dummy.next;
    }    
}

