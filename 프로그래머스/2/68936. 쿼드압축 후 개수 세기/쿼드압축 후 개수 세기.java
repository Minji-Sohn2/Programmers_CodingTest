class Solution {
    
    private int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    // 사각형 안의 수 확인
    // 배열, 사각형 왼쪽 위 좌표, 사각형 한 변의 길이 입력
    public boolean check(int[][] arr, int x, int y, int size){
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[x][y] != arr[i][j]) {
                    return false;   // 내부 숫자 중 하나라도 다른 경우
                }
            }
        }
        return true;    // 내부 숫자가 다 같은 경우
    }
    
    // 시작 좌표, 사이즈 입력 -> 압축
    public void quad(int[][] arr, int x, int y, int size) {
        // 정사각형 내부의 값이 모두 같을 경우 재귀 끝
        if(check(arr, x, y, size)){
            answer[arr[x][y]]++;
            return;
        }
        
        // 다를 경우 더 작은 정사각형으로 쪼개서 확인
        quad(arr, x, y, size/2);
        quad(arr, x+size/2, y, size/2);
        quad(arr, x, y+size/2, size/2);
        quad(arr, x+size/2, y+size/2, size/2);        
    }
}