import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            int numOfStudents = in.nextInt();
            int k = in.nextInt();
            int count = 0;
            boolean canceled = false;
            for (int j = 0; j < numOfStudents; j++) {
                int cur = in.nextInt();
                if (cur > 0) {
                    count++;
                }
                if (numOfStudents - count > k) {
                    canceled = true;
                    System.out.println("YES");
                    break;
                }
            }

        }
    }
}