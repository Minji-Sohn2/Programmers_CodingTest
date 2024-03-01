class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int hei : array) {
            if(hei >height) {
                answer++;
            }
        }
        return answer;
    }
}