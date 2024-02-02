import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 데이터의 칼럼 - data[]배열에서의 인덱스
        Map<String, Integer> column = new HashMap<>();
        column.put("code",0);
        column.put("date",1);
        column.put("maximum",2);
        column.put("remain",3);
        
        // 조건에 맞는 데이터 뽑아내기
        int extIndex = column.get(ext);
        List<int[]> resultDataList = new ArrayList<>();
        for(int[] d : data) {
            if (d[extIndex]<val_ext) {
                resultDataList.add(d);
            }
        }
        
        // sort_by 기준으로 데이터 정렬
        int sortByIndex = column.get(sort_by);
        resultDataList.sort(Comparator.comparingInt(row -> row[sortByIndex]));
        
        return resultDataList.toArray(new int[0][]);
    }
}