import java.util.*;

class Solution {
    // 정수 교점 좌표 저장할 list
    static List<int[]> list;
    // x, y 최대 최소 저장할 배열
    static int[] xMinMax; 
    static int[] yMinMax;


    public String[] solution(int[][] line) {
        list = new ArrayList<>();
        xMinMax = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        yMinMax = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        // 교점 구하기
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++) {
                // line[i] 와 line[j] 교점 구하는 함수
                getIntersectionPoint(line[i], line[j]);
            }
        }

        // 교점을 저장하기 위한 list
        List<String> answerList = new ArrayList<>();

        // y 최대부터 최소까지
        for (int i = yMinMax[1]; i >= yMinMax[0]; i--) {
            StringBuilder sb = new StringBuilder();
            // x 최소부터 최대까지
            for (int j = xMinMax[0]; j <= xMinMax[1]; j++) {
                
                boolean flag = false;
                
                for (int[] l : list) {
                    int x = l[0];
                    int y = l[1];
                    if(i == y && j == x) {
                        sb.append("*");
                        flag = true;
                        break;
                    }
                }
                // 교점 X
                if(!flag) {
                    sb.append(".");
                }
            }
            answerList.add(sb.toString());
        }

        return answerList.stream().toArray(String[]::new);
    }

    // 정수인 교점 구하는 함수
    public void getIntersectionPoint(int[] arr1, int[] arr2) {
        // ex) arr1 = {2, -1, 4}, arr2 = {-2, -2, 4}
        long a = arr1[0];
        long b = arr1[1];
        long c = arr2[0];
        long d = arr2[1];
        long e = arr1[2];
        long f = arr2[2];
        // 분모
        long denominator = a*d - b*c;

        // 역행렬이 존재하지 않을 때 -> 교점이 없음
        if(denominator == 0) {
            return;
        }

        long x = (b*f - d*e) / denominator;
        long y = (c*e - a*f) / denominator;

        // x, y가 둘 중 하나라도 정수가 아니라면
        if((b*f - d*e)%denominator==0 && (c*e - a*f)%denominator==0) {
            list.add(new int[] {(int)x,(int)y});

            // 범위 구하기 위해 최대 최소 저장
            xMinMax[0] = Math.min(xMinMax[0], (int)x);
            xMinMax[1] = Math.max(xMinMax[1], (int)x);
            yMinMax[0] = Math.min(yMinMax[0], (int)y);
            yMinMax[1] = Math.max(yMinMax[1], (int)y);
        }
    }
}