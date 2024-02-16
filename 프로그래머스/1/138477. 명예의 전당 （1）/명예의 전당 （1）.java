import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];   
        List<Integer> topK = new ArrayList<>();     // 명예의 전당
        
        for(int i=0; i<score.length; i++) {
            topK.add(score[i]);
            
            if(topK.size() > k) {                   // 명예의 전당 3명이 넘어가면
                topK.remove(Collections.min(topK)); // 그 중 가장 작은 값 제거
            }
            
            answer[i] = Collections.min(topK);      // 남은 점수 중 가장 작은 값
        }
        
        return answer;
    }
}