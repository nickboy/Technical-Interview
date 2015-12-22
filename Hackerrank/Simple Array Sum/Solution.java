import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner stdin = new Scanner(System.in);
        final int n = stdin.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stdin.nextInt();
        }
        System.out.println(sum);
    }
    
    
}