import java.util.*;

public class Solution {

	public int calculate(String s) {
		return calc(new StringTokenizer(s, " ()+-",  true));
	}

 	int calc(StringTokenizer st) {
 		int sofar = 0;
 		boolean plus = true; // 最後看到的是什麼符號，因只有加與減所以用boolean即可

 		while(st.hasMoreTokens()) {
 			int val = 0;
 			String next = st.nextToken();
 			System.out.println(next);
 			System.out.println(st);
 			switch (next) {
 				case "(":
 					val = calc(st);
 					sofar += (plus ? val : -val);
 					break;
 				case ")":
					return sofar;
				case "+":
					plus = true;
					break;
				case "-":
					plus = false;
					break;
				case " ":
					break;
				default :
					val = Integer.parseInt(next);
					sofar += (plus ? val : - val);
					break;
 			}
 		}
 		return sofar;
 	}

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int res = sol.calculate("(1+(4+5+2)-3)+(6+8)");
    	System.out.println(res);

    }
}