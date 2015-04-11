public class Solution {
    public boolean isNumber(String s) {
        int index=0, lengthOfString = s.length();
        boolean isNumeric = false;
        
        //try to ignore all whitespaces
        while(index<lengthOfString && Character.isWhitespace(s.charAt(index))) index++;
        
        //try to ignore all sign
        if (index<lengthOfString && (s.charAt(index)== '+' || s.charAt(index) == '-')) index++;
        
        while(index<lengthOfString && Character.isDigit(s.charAt(index))) {
            index ++;
            isNumeric = true;
        }
        
        //check decimal
        if(index<lengthOfString && ( s.charAt(index) == '.' )) {
            index++;
            while(index<lengthOfString && Character.isDigit(s.charAt(index))) {
                index ++;
                isNumeric = true;
            }
        }
        
        //check exponential
        if((isNumeric == true) && index<lengthOfString && s.charAt(index) == 'e'){
            index++;
            isNumeric = false;
            if(index<lengthOfString && (s.charAt(index) == '+' || s.charAt(index) == '-')) index++;
            
            while(index<lengthOfString && Character.isDigit(s.charAt(index))) {
                index ++;
                isNumeric = true;
            }
        }
        
        while(index<lengthOfString && Character.isWhitespace(s.charAt(index))) index++;
        return isNumeric && (index == lengthOfString);
        
    }
}