/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class HashMapSolution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // 此題hashmap的解法就是建立一個hashmap來對應舊list的node與新list node 的關係
        // 1 --> 1'
        // 2 --> 2'
        // 3 --> 3'
        // new   old
        // 接著不斷的去用containskey查是否新new已在裡面了，若在的話，則直接取出來用
        // 若不在的話，則用label建一個
        // 接著處理random的部份，也是用contaksKey(head.random)，來check是否在map裡面，
        // 若在的話，則取出來，把目前node.random指到此node
        // 若不在的話，則建一個新的，然後把newNode.random指給它
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;
        
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            
            pre.next = newNode;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            pre = newNode;
            head = head.next;
        }
        
        return dummy.next;
    }
}
