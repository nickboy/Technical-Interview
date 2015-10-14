public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return "";
        }
        if (a.length() == 0 || b.length() == 0) {
            return (a.length() == 0) ? a : b;
        }
        
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        
        int posA = lenA - 1;
        int posB = lenB - 1;
        int carry = 0;
        while (posA >= 0 && posB >= 0) {
            int digitA = a.charAt(posA) - '0';
            int digitB = b.charAt(posB) - '0';
            int sum = carry + digitA + digitB;
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, Integer.toString(sum));
            posA--;
            posB--;
        }
        
        if (posA >= 0) {
            while ( posA >= 0) {
                int digitA = a.charAt(posA) - '0';
                int sum = carry + digitA;
                carry = sum / 2;
                sum = sum % 2;
                sb.insert(0, Integer.toString(sum));
                posA--;
            }
        } else if (posB >= 0) {
            while (posB >= 0) {
                int digitB = b.charAt(posB) - '0';
                int sum = carry + digitB;
                carry = sum / 2;
                sum = sum % 2;
                sb.insert(0, Integer.toString(sum));
                posB--;
            }
        }
        if (carry == 1){
            sb.insert(0, Integer.toString(carry));
        }
        
        return sb.toString();
        
        
    }
}
