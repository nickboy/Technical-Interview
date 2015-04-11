public class Solution {
    
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    
    public int atoi(String str) {
        int index = 0, result =0;
        int lengthOfString = str.length();
        int sign = 1;
        
        //eliminate all white spaces
        while(index<lengthOfString && str.charAt(index) == ' ') index++;
        if(index<lengthOfString && str.charAt(index) == '-'){
            sign = -1;
            index++;
        }else if(index<lengthOfString && str.charAt(index) == '+'){
            sign = 1;
            index++;
        }
        
        while(index<lengthOfString && Character.isDigit(str.charAt(index))){
            //get the last digit and update the result!
            int digit = Character.getNumericValue(str.charAt(index));
            
            
            //overflow handling
            if (result > maxDiv10 || result == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 +digit;
            //move forward the point
            index++;
        }
        
        return sign * result;
    }
}