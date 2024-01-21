import java.util.*;

class Solution {
    
    private List<String> pathList = new ArrayList<>();  // 가능한 모든 경로 저장
    private boolean[] visited;  // dfs에서 방문한 경로 표시
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(0,"ICN","ICN",tickets);
        
        // 모든 경로 사전순으로 정렬
        Collections.sort(pathList);
        
        // 가장 앞의 경로를 String 배열로 분리
        return pathList.get(0).split(" ");
    }
    
    private void dfs(int depth, String current, String path, String[][] tickets) {
        // 모든 티켓을 사용한 경우 리스트에 추가
        if(depth==tickets.length) {
            pathList.add(path);
            return;
        }
        
        // 모든 티켓을 확인하며 다음에 사용할 티켓 찾기
        for(int i=0; i<visited.length; i++) {
            // 아직 사용하지 않은 티켓이고 현재 공항과 출발 공항이 일치하는 경우
            if(!visited[i] && current.equals(tickets[i][0])) {
                visited[i]=true;
                dfs(depth+1, tickets[i][1], path+" "+tickets[i][1], tickets);
                visited[i]=false;
            }
        }
    }
}