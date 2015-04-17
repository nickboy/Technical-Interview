public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> table = new HashMap<Character,Character>();
        table.put('(',')');
        table.put('{','}');
        table.put('[',']');
        
        char stringArray[] = s.toCharArray();
        Stack stack = new Stack();
        for(Character c:stringArray){
            if(table.containsKey(c)){
                stack.push(c);
            }else if(stack.isEmpty() || (table.get(stack.pop())!= c)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}