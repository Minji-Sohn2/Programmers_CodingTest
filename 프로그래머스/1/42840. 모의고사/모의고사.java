import java.util.*;

class Solution {
    
    public int[] solution(int[] answers) {
        Student student1 = new Student(1);
        student1.answer = new int[]{1, 2, 3, 4, 5};
        Student student2 = new Student(2);
        student2.answer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        Student student3 = new Student(3);
        student3.answer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        String[] answer3 = new String[5];

        // 반복 패턴 개수 나머지
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1.answer[i % 5]) {
                student1.score++;
            }
            if (answers[i] == student2.answer[i % 8]) {
                student2.score++;
            }
            if (answers[i] == student3.answer[i % 10]) {
                student3.score++;
            }
        }

        // 가장 높은 점수를 가진 학생 찾아 list에 추가
        int maxScore = Math.max(Math.max(student1.score, student2.score), student3.score);
        List<Integer> result = new ArrayList<>();
        if (maxScore == student1.score) {
            result.add(student1.name);
        }
        if (maxScore == student2.score) {
            result.add(student2.name);
        }
        if (maxScore == student3.score) {
            result.add(student3.name);
        }

        // list -> array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    class Student {
        int name;
        int score;
        int[] answer;

        public Student(int name) {
            this.name = name;
        }
    }
}
