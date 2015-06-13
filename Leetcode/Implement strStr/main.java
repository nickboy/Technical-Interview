public class Solution {
    public int strStr(String haystack, String needle) {
        //i for base, j for point
        for(int i=0;;i++){
            for(int j=0;;j++){
                //this means the needle was found in haystack.
                if(j == needle.length())
                    //return start point
                    return i;
                // return -1 since there is exceed the length of haystack.
                if(i+j == haystack.length())
                    return -1;
                //as long as there is one char is different, 
                //jump out the inner for loop and start a new base.
                if(needle.charAt(j) != haystack.charAt(i+j))
                    break;
            }
        }
    }
}