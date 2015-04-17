public class Solution {
    public int romanToInt(String s) {
        //M = 1000
        //D = 500
        //C = 100
        //L = 50
        //X = 10
        //V = 5
        //I = 1
        
        HashMap<Character,Integer> table = new HashMap<Character,Integer>();
        table.put('M',1000);
        table.put('D',500);
        table.put('C',100);
        table.put('L',50);
        table.put('X',10);
        table.put('V',5);
        table.put('I',1);
        table.put(' ',0);
        
        char stringArray[] = s.toCharArray();
        int length = stringArray.length;
        int result = table.get(stringArray[0]);
        
        for(int i=1 ; i<length ; i++){
            int previous = table.get(stringArray[i-1]);
            int current = table.get(stringArray[i]);
            if(previous>=current){
                result += current;
            }else{
                result = result - 2*previous + current;
            }
        }
        return result;
    }
}