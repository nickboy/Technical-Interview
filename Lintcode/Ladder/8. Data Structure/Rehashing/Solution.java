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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int newSize = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[newSize];
        
        Arrays.fill(newHashTable, null);
        for (int i = 0; i < hashTable.length; i++) {
            ListNode head = hashTable[i];
            while (head != null) {
                //avoid negative value
                int index = (head.val % newSize + newSize) % newSize;
                newHashTable[index] = addNode(newHashTable[index], head);
                head = head.next;
            }
        }
        return newHashTable;
    }
    
    private ListNode addNode(ListNode head, ListNode node) {
        //記得要new node，否則list會越接越長
        if (head == null) {
            return new ListNode(node.val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = new ListNode(node.val);
        return dummy.next;
    }
};

