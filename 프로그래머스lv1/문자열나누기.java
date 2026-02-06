package 프로그래머스lv1;

public class 문자열나누기 {
    /* 핵심 로직 : 로직 순서를 바꾸어 문자열 끝 처리를 없앰 */

    // 나의 풀이
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        int countX = 0;
        int countNotX = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(index);
            if(ch == s.charAt(i)){
                countX++;
            }else{
                countNotX++;
            }
            if(countX == countNotX){
                index = i+1;
                countX = 0;
                countNotX = 0;
                answer++;
            }else{
                if(i == s.length()-1){
                    answer++;
                }
            }
        }

        return answer;
    }

    // Gemini 개선 풀이
    // index 변수를 제거하고 x 갱신 시점을 countX와 countNotX가 같을 때로 이동함으로써 로직이 간결해짐
    // 그리고 로직 순서를 변경함으로써 문자열 끝의 조건을 명시할 필요없이 처리 가능
    public int solutionGemini(String s) {
        int answer = 0;
        
        // 현재 기준이 되는 문자 (첫 번째 문자)
        char x = s.charAt(0);
        
        int countX = 0;
        int countNotX = 0;

        for (int i = 0; i < s.length(); i++) {
            // 1. 새로운 그룹의 시작이라면 기준 문자(x) 재설정
            if (countX == countNotX) {
                answer++;
                x = s.charAt(i); // 기준 문자 갱신
                // 카운트 초기화 (사실상 아래 로직을 위해 필요한 개념적 초기화)
                countX = 0;
                countNotX = 0;
            }

            // 2. 개수 세기
            if (s.charAt(i) == x) {
                countX++;
            } else {
                countNotX++;
            }
        }

        return answer;
    }
}
