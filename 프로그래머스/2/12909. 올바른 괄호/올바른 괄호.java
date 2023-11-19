import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty() || c=='(') {
                stack.push(c);
            } else if(c==')') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}