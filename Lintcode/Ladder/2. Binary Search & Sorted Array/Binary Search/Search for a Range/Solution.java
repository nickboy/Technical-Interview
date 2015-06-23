public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here

        
        int start;
        int end;
        int mid; 
        int midValue;
        int[] range = {-1, -1};
        
        if (A.size() == 0) {
            //you can not direct pass array as paramemter to constructor
            return new ArrayList<Integer>(Arrays.asList(range[0], range[1]));
        }
        
        
        //search lower bound
        start = 0;
        end = A.size() - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            midValue = A.get(mid);
            if (midValue == target) {
                //move end ahead since you need to find the first occur element
                end = mid;
            } else if (midValue < target) {
                start = mid;
            } else if (midValue > target) {
                end = mid;
            }
        }
        //since you need to find first occur element, detect start first.
        if (A.get(start) == target) {
            range[0] = start;
        } else if (A.get(end) == target) {
            range[0] = end;
        } else {
            //return directly, since you can not find anything
            range[0] = range[1] = -1;
            return new ArrayList<Integer>(Arrays.asList(range[0], range[1]));
        }
        
        //search upper bound
        start = 0;
        end = A.size() - 1;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            midValue = A.get(mid);
            if (midValue == target) {
                // move start backward since you need to find the last occur element
                start = mid;
            } else if (midValue < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // detect end first, since you need to find the last occur element.
        if (A.get(end) == target) {
            range[1] = end;
        } else if (A.get(start) == target) {
            range[1] = start;
        } else {
            range[1] = range[0] = -1;
            return new ArrayList<Integer>(Arrays.asList(range[0], range[1]));
        }
        
        return new ArrayList<Integer>(Arrays.asList(range[0], range[1]));
    }
}

