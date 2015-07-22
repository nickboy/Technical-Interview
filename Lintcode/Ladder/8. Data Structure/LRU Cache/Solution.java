public class Solution {
    
    //使用一個雙向鏈表，並設定key，val，因set func需要key value
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    // @param capacity, an integer
    // 使用capacity來計錄cache的大小
    // 使用頭尾兩個node來紀錄前後
    // 使用HashMap當作cache，並直接紀錄該點在鏈表的哪個位置
    // 使用雙向鏈表是為了刪減移動方便
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    public Solution(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        //若cache裡找不到則返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        // 若有的話，則直接透過map把該點抓出來
        // 並改變該node前後node的pointer references
        // 再把該node透過func移到尾端
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        moveToTail(cur);
        
        return cur.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        //若找得到該node，則直接改該node的值
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        //若超出的話，則把最前面那個node從cache中刪除
        //並且改變head與該點下一個的pointer references
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        // 建一個新node並存到cache中，再透過func移到list最後面
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    
    // 把current移到尾巴
    // 因前面get function已處理了current前後點的pointer references
    // 在這裡只需要處理current，tail與tail.prev的pointer references
    public void moveToTail(Node current) {
        current.prev = tail.prev;
        tail.prev.next = current;
        tail.prev = current;
        current.next = tail;
        
    }
}
