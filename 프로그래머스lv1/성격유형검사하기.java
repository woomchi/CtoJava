package 프로그래머스lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    /* 핵심 로직 : 제한적인 범위이므로 하드 코딩이 가독성이 좋음 */

    // 나의 풀이
    // 매직 넘버 연산이 존재함
    // 이미 처음에 0으로 초기화했기 때문에 getOrDefault 사용 불필요함
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> type = new HashMap<>();
        type.put('R', 0);   type.put('T', 0);
        type.put('C', 0);   type.put('F', 0);
        type.put('J', 0);   type.put('M', 0);
        type.put('A', 0);   type.put('N', 0);

        for(int i = 0 ; i < survey.length; i++){
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            if(choices[i]/4 > 0){
                type.put(agree, type.getOrDefault(agree, 0)+choices[i]%4);
            }else{
                type.put(disagree, type.getOrDefault(disagree, 0)+(4 - choices[i]%4));
            }
        }

        String types = "RTCFJMAN";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < types.length() ; i += 2){
            if(type.get(types.charAt(i)) > type.get(types.charAt(i+1))){
                sb.append(types.charAt(i));
            }else if(type.get(types.charAt(i)) == type.get(types.charAt(i+1))){
                sb.append(types.charAt(i) < types.charAt(i+1) ? 
                          types.charAt(i) : types.charAt(i+1));
            }else{
                sb.append(types.charAt(i+1));
            }
        }

        String answer = sb.toString();
        return answer;
    }

    // Gemini 개선 풀이
    public String solutionGemini(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();

        // 1. 점수 계산 로직 단순화
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i] - 4; // -3 ~ 3 사이의 값 도출
            
            if (score > 0) {
                // 양수면 뒤쪽 문자(동의)에 점수 더하기
                char agree = survey[i].charAt(1);
                scores.put(agree, scores.getOrDefault(agree, 0) + score);
            } else if (score < 0) {
                // 음수면 앞쪽 문자(비동의)에 점수 더하기 (절댓값 사용)
                char disagree = survey[i].charAt(0);
                scores.put(disagree, scores.getOrDefault(disagree, 0) + Math.abs(score));
            }
            // 0인 경우(모르겠음)는 아무것도 하지 않아도 됨
        }

        // 2. 결과 조합 (StringBuilder 사용)
        StringBuilder sb = new StringBuilder();
        
        // 지표별로 묶어서 처리 (이미 알파벳 순인 '사전순'으로 배열 정의)
        // R vs T
        sb.append(scores.getOrDefault('R', 0) >= scores.getOrDefault('T', 0) ? 'R' : 'T');
        // C vs F
        sb.append(scores.getOrDefault('C', 0) >= scores.getOrDefault('F', 0) ? 'C' : 'F');
        // J vs M
        sb.append(scores.getOrDefault('J', 0) >= scores.getOrDefault('M', 0) ? 'J' : 'M');
        // A vs N
        sb.append(scores.getOrDefault('A', 0) >= scores.getOrDefault('N', 0) ? 'A' : 'N');

        return sb.toString();
    }
}
