public class Solution {

    // 다양한 unit 크기에 대한 최소 압축 길이를 찾는 주요 메서드
    public int solution(String s) {
        int answer = s.length();

        // 가능한 청크 크기를 반복
        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = compressString(s, i);
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

    // 주어진 unit 크기로 문자열을 재귀적으로 압축하는 메서드
    private String compressString(String s, int unitSize) {
        // 기본 경우 : 남은 문자열이 unit 크기보다 짧으면 그대로 반환
        if (s.length() < unitSize) {
            return s;
        }

        // 압축된 문자열을 저장할 StringBuilder 초기화
        StringBuilder compressed = new StringBuilder();

        // 현재 청크와 남은 문자열 추출
        String currentUnit = s.substring(0, unitSize);
        String remainingString = s.substring(unitSize);

        // 다음 unit이 다르면 확인
        if (!remainingString.startsWith(currentUnit)) {
            // 현재 unit의 압축된 표현을 추가하고 남은 문자열에 대해 재귀 호출
            compressed.append(buildChunkRepresentation(1, currentUnit));
            compressed.append(compressString(remainingString, unitSize));
        } else {
            // 다음 unit이 동일하면 카운트를 증가시키고 재귀 호출
            compressed.append(compressString(remainingString, unitSize, 2));
        }

        // StringBuilder를 String으로 변환하고 반환
        return compressed.toString();
    }

    // unit이 일치하는 경우를 처리하는 오버로드된 메서드
    private String compressString(String s, int unitSize, int count) {
        // 압축된 문자열을 저장할 StringBuilder 초기화
        StringBuilder compressed = new StringBuilder();

        // 현재 unit과 남은 문자열 추출
        String currentUnit = s.substring(0, unitSize);
        String remainingString = s.substring(unitSize);

        // 다음 unit이 다르면 확인
        if (!remainingString.startsWith(currentUnit)) {
            // 현재 unit의 압축된 표현을 추가하고 남은 문자열에 대해 재귀 호출
            compressed.append(buildChunkRepresentation(count, currentUnit));
            compressed.append(compressString(remainingString, unitSize));
        } else {
            // 다음 unit이 동일하면 카운트를 증가시키고 재귀 호출
            compressed.append(compressString(remainingString, unitSize, count + 1));
        }

        // StringBuilder를 String으로 변환하고 반환
        return compressed.toString();
    }

    // unit의 압축된 표현을 만들기 위한 도우미 메서드
    private String buildChunkRepresentation(int count, String unit) {
        // 카운트가 1이면 unit 그대로 반환, 그렇지 않으면 카운트를 추가
        return (count == 1) ? unit : count + unit;
    }
}
