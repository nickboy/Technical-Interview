import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int[] nums = new int[n];
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            
            if (nums[i] < 0) {
                negative++;
            } else if (nums[i] > 0) {
                positive++;
            } else {
                zeros++;
            }
        }
        
        double posFraction = positive / (double)(n * 1.0);
        double negFraction = negative / (double)(n * 1.0);
        double zerosFraction = zeros / (double)(n * 1.0);
        
        System.out.println(posFraction);
        System.out.println(negFraction);
        System.out.println(zerosFraction);
    }
}