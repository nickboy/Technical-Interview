public class LRUCache {
    
    //建雙向list的node
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    //使用hashmap來當作cache，如果node在cache裡的話，每個key會對到特定的node
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head;
    Node tail;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    // 有在cache的話，則把該node從cache取出來，改一下他前後node的pointer，接著把該node接到tail
    // 若沒有則返回1
    public int get(int key) {
        Node curNode;
        if (map.containsKey(key)) {
            curNode = map.get(key);
        } else {
            return -1;
        }
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        moveToTail(curNode);
        return curNode.value;
    }
    
    // 有在cache裡的話，則改它的值，並且更更改該node前後node的pointer，接著把該node接到tail
    // 若不在cache裡的話，則新建一個node，接著判斷是否有超過size，
    // 有的話，把head.next(即least used node)刪掉，接著把新node接到tail
    // 沒超過的話，直接把新node接到tail
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            moveToTail(temp);
            return;
        }
        Node temp = new Node(key, value);
        if (map.size() == size) {
            map.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;
        }
        moveToTail(temp);
        map.put(key, temp);
        
    }
    // 這裡只處理把cur與tail.prev跟tail相接
    public void moveToTail(Node cur) {
        tail.prev.next = cur;
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev = cur;
        
    }
}