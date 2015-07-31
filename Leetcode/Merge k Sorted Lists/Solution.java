/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //因為是要從小到大，所以用A來減B，若是反過來的話，則順序要相反
    public Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode A, ListNode B) {
            if (A == null) {
                return 1;
            }
            if (B == null) {
                return -1;
            }
            return A.val - B.val;
        }
    };
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // 建一個priority queue，把lists中的每個head全塞到queue中
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) 
                queue.add(lists[i]);
        }
        //接著不斷把queue的頭pop出來托到tail後面，若後面還有，則push回queue中
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            tail.next = temp;
            tail = tail.next;
            temp = temp.next;
            if (temp != null) {
                queue.add(temp);
            }
        }
        return dummy.next;
    }
}