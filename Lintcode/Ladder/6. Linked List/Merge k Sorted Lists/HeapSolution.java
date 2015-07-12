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
public class HeapSolution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    //因要使用priorit queue，因此需要設定comparator讓它知道如何比大小 
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        } 
        //先建立一個priority queue，接著把每個list的head加到queue中
        //priority queue 的 複雜度
        // Find min : O(1)
        // Insert : O(logN)
        // delete : O(logN)
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        // 類似合併2 lists，差別在於不斷從heap中拿出最小值，插入list中，
        // 若next不為空的話，則把next插入heap中
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            if (head.next != null) {
                heap.add(head.next);
            }
            tail = tail.next;
        }
        
        return dummy.next;
    }
}

