class Solution {
    public int[] solution(String s) {
        int[] alphabet = new int[26];
        for(int i=0; i<26; i++) {
            alphabet[i] = -1;
        }
        
        int[] answer = new int[s.length()];
        char[] sCharArr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            char ch = sCharArr[i];
            if(alphabet[ch-'a'] == -1) {
                answer[i] = alphabet[ch-'a'];
            } else {
                answer[i] = i-alphabet[ch-'a'];
            }
            
            alphabet[ch-'a'] = i;
        }
        
        return answer;
    }
}