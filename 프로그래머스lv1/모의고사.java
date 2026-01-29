package 프로그래머스lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    // 나의 풀이
    // 답지의 길이가 길다면 한 명 한 명 채점하는 것보다 한 문제씩 3명을 채점하는게 성능상 좋음
    // 매직 넘버보다는 확실한 변수를 쓰는게 좋음
    public int[] solution(int[] answers) {
        int[][] pattern = {{1,2,3,4,5},
                           {2,1,2,3,2,4,2,5},
                           {3,3,1,1,2,2,4,4,5,5}};

        int[] count = new int[3];
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < answers.length; i++){
                if(answers[i] == pattern[j][i%pattern[j].length])   count[j]++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int maxValue = Math.max(count[0], Math.max(count[1], count[2]));
        for(int i = 0; i < 3; i++){
            if(maxValue == count[i])    list.add(i+1);
        }
        int [] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    // Gemini 개선 풀이
    public int[] solutionGemini1(int[] answers) {
    // 2차원 배열로 패턴 정의 (가독성 좋음)
    int[][] pattern = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    int[] count = new int[pattern.length]; // 3 대신 길이 사용

    // 개선 포인트 1: answers를 한 번만 순회
    for (int i = 0; i < answers.length; i++) {
        for (int j = 0; j < pattern.length; j++) {
            // 나머지 연산으로 패턴 반복 처리
            if (answers[i] == pattern[j][i % pattern[j].length]) {
                count[j]++;
            }
        }
    }

    // 최대값 구하기 (Math.max 중첩 대신 stream 활용 가능하지만, 현재 방식도 충분히 좋음)
    int maxScore = Math.max(count[0], Math.max(count[1], count[2]));

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < count.length; i++) {
        if (maxScore == count[i]) {
            list.add(i + 1);
        }
    }

    // 개선 포인트 2: 스트림을 활용한 배열 변환 (가장 실용적인 스트림 활용 예시)
    return list.stream().mapToInt(i -> i).toArray();
}
}
