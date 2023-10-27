class Solution {
    boolean solution(String s) {

        char[] sArr = s.toCharArray();
        int p = 0;
        int y = 0;
        for(char ch : sArr) {
            if(ch=='p' || ch=='P'){
                p++;
            } else if(ch=='y' || ch=='Y') {
                y++;
            }
        }

        return true ? p==y : p!=y;
    }
}