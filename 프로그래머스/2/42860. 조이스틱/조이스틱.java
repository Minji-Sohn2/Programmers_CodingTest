class Solution {
    public int solution(String name) {
        int answer = 0;
        int index = 0;
        int move = name.length()-1; // 최대 좌우이동 횟수
        
        for(int i=0; i<name.length(); i++) {
            // 목표 알파벳까지 위로/ 아래로 움직여야 하는 횟수 최솟값
            answer += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            
            // 오른쪽으로 이동하면서 다음 'A'가 아닌 위치 찾기
            index = i+1;
            while(index<name.length() && name.charAt(index)=='A') {
                index++;
            }
            
            // 순서대로 or 거꾸로 하는 것 중 이동수가 적은 것 고르기
            // ex) BBAAAABB -> i + i + name.length - index
            move = Math.min(move, i*2+name.length()-index);
            // 뒷부분 입력 후 맨 처음을 입력하는 경우와 비교 후 더 적은 것 고르기
            move = Math.min(move, (name.length()-index)*2+i);
        }
        
        return answer+move;
    }
}
