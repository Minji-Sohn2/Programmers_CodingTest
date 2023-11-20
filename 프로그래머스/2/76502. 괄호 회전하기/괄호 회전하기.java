import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            String str = s.substring(i, s.length()) + s.substring(0, i);
            if(check(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();
            
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            
            if(stack.isEmpty()) {
                stack.push(c);
            } else if(c==')' && stack.peek()=='(') {
                stack.pop();
            } else if(c=='}' && stack.peek()=='{') {
                stack.pop();
            } else if(c==']' && stack.peek()=='[') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
         
        return stack.isEmpty();
    }
}