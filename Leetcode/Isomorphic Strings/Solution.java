public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<Character, Character>();
        HashMap<Character, Character> mapT = new HashMap<Character, Character>();
        if (s.length() == 0) {
            return true;
        }
        // 題意是兩個字串是否為同構，即某個字能否透過換char得到另一個字，
        // 若string中有5個a要換，一但a換成s，所有5個a都要換成s
        // 解法如下：
        // 用兩個hashmap，mapS的key為charT，value為charS 即代表s string的charS要換成charT
        // 用兩個hashmap，mapT的key為charS，value為charT 即代表t string的charT要換成charS
        // 一但加入到map中，則表示該value要換成key所代表的char
        for (int i = 0; i < s.length(); i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);
            // 已存在了，因此拿出來比看看跟之前換的一不一樣，若不一樣則返回false
            if (mapS.containsKey(charT) && mapS.get(charT) != charS) {
                return false;
            }

            if (mapT.containsKey(charS) && mapT.get(charS) != charT) {
                return false;
            }
            //若皆不存在，則把該轉換加入這兩個map中，繼續下一輪的比較
            if (!mapS.containsKey(charT) && !mapT.containsKey(charS)) {
                mapS.put(charT, charS);
                mapT.put(charS, charT);
            }
        }
        return true;
    }
}
