package 코딩테스트lv1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 과일장수 {

class Solution {
    // 나의 풀이
    // 불필요한 자료구조 사용
    // 불필요한 서브리스트
    // 불필요한 Collections 메서드 사용
    // Arrays.sort로 간단히 해결할 문제임
    public int solution(int k, int m, int[] score) {
        int numFruit = score.length;
        int numBox = score.length/m;
        List<Integer> list = new ArrayList<>(numFruit);
        for(int i : score){
            list.add(i);
        }

        Collections.sort(list, Collections.reverseOrder());
        int minValue = 0;
        List<Integer> tempList = new ArrayList<>(m);
        for(int i = 0; i/m < numBox; i++){
            if((i+1)%m == 0){
                tempList.add(list.get(i));
                minValue += Collections.min(tempList);
                tempList.clear();

            }else{
                tempList.add(list.get(i));
            }
        }

        int answer = minValue * m;
        return answer;
    }

    // Gemini 개선 풀이
    public int solutionGemini(int k, int m, int[] score) {
        int answer = 0;

        // 1. 기본 배열을 오름차순 정렬 (속도: Arrays.sort > Collections.sort)
        Arrays.sort(score);

        // 2. 뒤에서부터 m개씩 건너뛰며 순회
        // score.length가 10이고 m이 4라면: 인덱스 6, 2 를 참조하게 됨
        for (int i = score.length - m; i >= 0; i -= m) {
            
            // 3. 해당 그룹의 최솟값은 현재 인덱스(i)의 값임 (오름차순이므로)
            // 박스 가격 = 최솟값 * m
            answer += score[i] * m;
        }

        return answer;
    }
}
}
