public class Solution {
    public boolean isHappy(int n) {
        int number = 0;
        HashSet<Integer> list = new HashSet<Integer>();
        while(!list.contains(n)){
            list.add(n);
            number = 0;
            while (n !=0){
                number = number + (n%10) * (n%10);
                n = n / 10;
            }
            n = number;
            if(n==1 || n==7)
                return true;
        }
        return false;
    }
}