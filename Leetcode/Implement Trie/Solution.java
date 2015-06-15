class TrieNode {
    // Initialize your data structure here.
    Map<Character,TrieNode> next;
    boolean isValue = false;
    public TrieNode() {
        next = new HashMap<Character, TrieNode>();
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Character c = word.charAt(i);
            if (!current.next.containsKey(c)) {
                TrieNode node = new TrieNode();
                current.next.put(c, node);
            }
            current = current.next.get(c);
        }
        current.isValue = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Character c = word.charAt(i);
            if (!current.next.containsKey(c)) {
                return false;
            } else {
                current = current.next.get(c);
            }
        }
        if (current.isValue == true) {
            return true;
        } else {
            return false;
        }
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            Character c = prefix.charAt(i);
            if (!current.next.containsKey(c)) {
                return false;
            } else {
                current = current.next.get(c);
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");