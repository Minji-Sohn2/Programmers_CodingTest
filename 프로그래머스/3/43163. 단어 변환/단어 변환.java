import java.util.*;

class Solution {
    private List<String> wordList;
    
    public int solution(String begin, String target, String[] words) {
        wordList = Arrays.asList(words);
        
        //List에 target이 있는지 먼저 체크
        if(!wordList.contains(target)) {
            return 0;
        }
        
        return bfs(begin, target);
    }
    
    private int bfs(String begin, String target) {
        Queue<String> queue = new LinkedList<>(); // 처리 대기 중인 단어들
        Set<String> wordSet = new HashSet<>(wordList); // 남은 단어들의 집합 (중복 없앰)
        
        queue.offer(begin);
        int answer = 0;
        
        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                String current = queue.poll();
                
                if(current.equals(target)) {
                    return answer;
                }
                
                Iterator<String> iterator = wordSet.iterator();
                while(iterator.hasNext()) {
                    String word = iterator.next();
                    
                    if(canConvert(current,word)) {
                        queue.offer(word);
                        iterator.remove();  // 다시 방문하지 않도록
                    }
                }
            }
            
            answer++;
        }
        
        return 0;
    }
    
    // 한글자만 다른지 확인
    private boolean canConvert(String word1, String word2) {
        int diff=0;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff==1;
    }
}