class Solution {
    public String solution(int a, int b) {
        int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int monthSum = b;
        for(int i=0; i<a-1; i++) {
            monthSum += months[i];
        }
        
        return week[monthSum%7];
    }
}