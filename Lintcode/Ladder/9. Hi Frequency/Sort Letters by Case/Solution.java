public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int start = 0;
        int end = chars.length - 1;
        while (start <= end) {
            while (start <= end && (int) chars[start] >= 97) {
                start++;
            }
            while (start <= end && (int) chars[end] < 97) {
                end--;
            }
            if (start <= end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
    }
}

