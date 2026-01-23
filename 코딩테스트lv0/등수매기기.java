package 코딩테스트lv0;

import java.util.ArrayList;
import java.util.List;

public class 등수매기기 {
    // 나의 풀이
    // 굳이 double로 연산하여 오차를 만들 이유가 없음 => 두 과목의 합으로도 충분함
    // 배열 요소 초기화할 때 += 쓰지 말고 = 쓰기
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] average = new double[score.length];
        for(int i=0;i<score.length;i++){
            average[i] += (double)(score[i][0]+score[i][1])/2;
        }
        
        for(int k=0;k<score.length;k++){
            int count = 1;
            for(int i=0;i<score.length;i++){
                double criteria = average[k];
                if(criteria < average[i])   count++;
            }
            answer[k] = count;
        }
            
        
        return answer;
    }
    
    // 리펙터링1 - List 활용
    public int[] solution1(int[][] score) {
        List<Integer> list = new ArrayList<>();
        for(int[] data : score){
            list.add(data[0] + data[1]);
        }
        
        int[] answer = new int[score.length];
        for(int i=0;i<score.length;i++){
            int count = 1;
            int criteria = list.get(i);
            for(int data: list){
                if(criteria<data)   count++;
            }
            answer[i] = count;
        }

        return answer;
    }

    //Gemini 개선 풀이
    public int[] solutionGemini(int[][] score) {
        int[] answer = new int[score.length];
        int[] sum = new int[score.length]; // double 대신 int 총점 배열

        // 1. 평균 대신 총점 구하기 (나눗셈 제거)
        for(int i = 0; i < score.length; i++){
            sum[i] = score[i][0] + score[i][1];
        }

        // 2. 등수 매기기 logic 유지
        for(int k = 0; k < score.length; k++){
            int count = 1;
            for(int i = 0; i < score.length; i++){
                // 총점으로 비교 (결과는 동일)
                if(sum[k] < sum[i]) {
                    count++;
                }
            }
            answer[k] = count;
        }

        return answer;
    }
}
