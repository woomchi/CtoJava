package 프로그래머스lv1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {
    // 나의 풀이
    // 불필요한 배열 선언 및 사용
    // substring으로 객체 재생성 빈번함
    // 코드의 길이도 길어서 가독성이 떨어짐
    public int solution(String dartResult) {
        final int chance = 3;
        int [] num = new int[chance];
        char [] bonus = new char[chance];
        char [] option = new char[chance];

        String s = dartResult;
        for(int i = 0 ; i < chance ; i++){
            int index = 0;
            char c;
            while(index < s.length()){
                c = s.charAt(index);
                if(c == 'S'){
                    bonus[i] = 'S';
                    break;
                }else if(c == 'D'){
                    bonus[i] = 'D';
                    break;
                }else if(c == 'T'){
                    bonus[i] = 'T';
                    break;
                }
                index++;
            }
            num[i] = Integer.parseInt(s.substring(0, index));
            if(index+1 < s.length()){
                c = s.charAt(index+1);
                if(c == '*'){
                    option[i] = '*';
                }else if(c == '#'){
                    option[i] = '#';
                }else{
                    option[i] = 'n';
                }
            }else{
                option[i] = 'n';
            }

            if(option[i] == '*'){
                s = s.substring(index+2);
            }else if(option[i] == '#'){
                s = s.substring(index+2);
            }else{
                s = s.substring(index+1);
            }
        }

        int answer = 0 ;
        int [] cal = new int[chance];
        char [] sdt = { 'S', 'D', 'T'};
        for(int i = 0 ; i < chance ; i++){
            for(int j = 0 ; j < sdt.length; j++){
                if(bonus[i] == sdt[j]){
                    cal[i] += Math.pow(num[i], j+1);
                }
            }
            if(option[i] == '*'){
                if(i >=1 ){
                    cal[i-1] *= 2;
                }
                cal[i] *= 2;
            }else if(option[i] == '#'){
                cal[i] *= -1;
            }
        }
        for(int i = 0 ; i < chance ; i++){
            answer += cal[i];
        }
        return answer;
    }

    // Gemini 개선풀이 - 정규 표현식 및 Pattern 활용
    public int solutionGemini(String dartResult) {
        // 1. 정규식 패턴: (숫자 그룹)(보너스 그룹)(옵션 그룹)
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        
        int[] scores = new int[3]; // 3번의 기회 점수 저장
        int idx = 0; // 현재 기회 인덱스

        // 2. 패턴 매칭 반복 (총 3번 매칭됨)
        while (matcher.find()) {
            // 그룹 1: 점수 파싱
            int n = Integer.parseInt(matcher.group(1));
            
            // 그룹 2: 보너스 처리 (S, D, T)
            String bonus = matcher.group(2);
            if (bonus.equals("D")) {
                n = n * n; // 제곱
            } else if (bonus.equals("T")) {
                n = n * n * n; // 세제곱
            }
            
            // 점수 임시 저장
            scores[idx] = n;

            // 그룹 3: 옵션 처리 (*, #)
            String option = matcher.group(3);
            if (option.equals("*")) {
                scores[idx] *= 2; // 현재 점수 2배
                if (idx > 0) {
                    scores[idx - 1] *= 2; // 이전 점수 2배
                }
            } else if (option.equals("#")) {
                scores[idx] *= -1; // 마이너스
            }
            
            idx++;
        }

        // 3. 최종 합계
        return scores[0] + scores[1] + scores[2];
    }
}
