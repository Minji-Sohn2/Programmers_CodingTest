import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        double[] newArr = new double[numlist.length];
        
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] - n < 0) {
                newArr[i] = ((int)Math.abs(numlist[i] - n)) + 0.5;
            } else  {
                newArr[i] = numlist[i] - n; 
            }
        }
        
        Arrays.sort(newArr); 
        
        for(int i = 0; i < numlist.length; i++) {
            if(newArr[i] % 1 != 0) {
                answer[i] = n - (int)newArr[i];
            } else {
                answer[i] = (int)newArr[i] + n;
            }
        }
        
        return answer;
    }
}