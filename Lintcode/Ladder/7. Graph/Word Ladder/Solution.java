public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.remove(start);
        
        int length = 1;
        
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String current = queue.poll();
                
                // 此兩個for loop是分把把current string中的每一個位置char分別帶入a-z中來檢查
                // 使用另一個replace 方法來幫助
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        
                        //若目前的char與string該位置的char相同，則直接跳到下一個
                        if (c == current.charAt(j)) {
                            continue;
                        }
                        String temp = replace(current, j, c);
                        if (temp.equals(end)) {
                            return length + 1;
                        }
                        // 每產生一個string，就去check一下是否有在dict裡面，
                        // 若有，則加入到queue中，等待下一次traverse
                        // 若無，則skip
                        if (dict.contains(temp)) {
                            queue.add(temp);
                            dict.remove(temp);
                        }
                        
                    }
                }
            }
            length++;
        }
        return 0;
    }
    
    
    // char.toString與new String(char)不一樣，
    // 因為char.toString是把一個pointer轉成string
    // 除非用Arrays.toString(char)
    private String replace(String str, int index, char c) {
        char[] charArray = str.toCharArray();
        charArray[index] = c;
        return new String(charArray);
    }
}
