class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1; i < triangle.length ; i++) {
            
	        for(int j = 0; j < triangle[i].length ; j++) {

		        if(j == 0) {        // 지금 행의 왼쪽 끝 열일 경우
			        triangle[i][j] += triangle[i-1][j];
		        }
		        else if(j == i) {   // 지금 행의 오른쪽 끝 열일 경우
			        triangle[i][j] += triangle[i-1][j-1];
		        }
		        else {              // 지금 행의 중간 열 중 하나일 경우
                    // 왼쪽 위와 더한 값, 오른쪽 위와 더한 값을 비교 후 더 큰 값을 기록
			        triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
		        }

                // 매번 answer와 비교
		        answer = Math.max(answer, triangle[i][j]);
	        }
        }
        return answer;
    }
}