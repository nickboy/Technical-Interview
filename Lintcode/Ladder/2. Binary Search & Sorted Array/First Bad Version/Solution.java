/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if ( n == 1 ) {
            if (VersionControl.isBadVersion(1))
                return 1;
            else 
                return 0;
        } 
        
        int start = 1;
        int end = n;
        int mid;
        boolean midIsBad;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            midIsBad = VersionControl.isBadVersion(mid);
            //若mid是bad，則第一個bad在前半段
            //否則bad會發生在後半段
            if (midIsBad) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (VersionControl.isBadVersion(start)) {
            return start;
        }
        if (VersionControl.isBadVersion(end)) {
            return end;
        }
        return 0;
    }
}

