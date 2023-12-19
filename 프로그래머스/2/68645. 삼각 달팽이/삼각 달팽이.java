import java.util.*;

class Solution {
    
    // 방향 설정
    private int[] dx = {0, 1, -1};  // 아래, 오른쪽, 왼쪽 위
    private int[] dy = {1, 0, -1};  // 아래, 오른쪽, 왼쪽 위
    private int[][] arr;
    
    public int[] solution(int n) {
        // 삼각형을 채울 2차원 배열
        arr = new int[n][n];
        // 삼각형을 채우는 가장 마지막 숫자
        int max = n*(n+1)/2;
        
        fillArr(n, max);
        
        return flatArr();
    }
    
    private void fillArr(int n, int max) {
        int index = 0;
        int x=0, y=0;
        for(int i=1; i<=max; i++) {
            arr[y][x] = i;
            
            int ny = y + dy[index];
            int nx = x + dx[index];
            
            // 배열의 끝에 도달했거나 이미 숫자가 채워졌다면 방향 바꾸기
            if(ny==n || ny==-1 || nx==n || nx==-1 || arr[ny][nx]!=0) {
                index = (index + 1)%3;  // 방향 바꾸기
                ny = y + dy[index];
                nx = x + dx[index];
            }
            
            y=ny;
            x=nx;
        }
    }
    
    private int[] flatArr() {
        List<Integer> flatList = new ArrayList<>();
        
        for(int[] row : arr) {
            for(int i : row) {
                if(i!=0) {
                   flatList.add(i); 
                }
            }
        }
        
        return flatList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}