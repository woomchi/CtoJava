package 프로그래머스lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 숫자짝궁 {
    // 나의 풀이
    // 한정적 범위에서는 map보다 배열 성능이 뛰어남
    // 땜질 조건문이 있어 이를 첫글자가 0이면 0으로 처리하는 로직이 흐름상 나음
    // 굳이 TreeMap을 섞어 쓸 필요없음(의미없음)
    // Collections.sort 할 바에는 역순으로 조회하여 추가하는게 더 좋음
    public String solution(String X, String Y) {
        HashMap<Character, Integer> x_map = new HashMap<>();
        HashMap<Character, Integer> y_map = new HashMap<>();
        for(int i = 0 ; i < X.length(); i++){
            x_map.put(X.charAt(i), x_map.getOrDefault(X.charAt(i), 0)+1);
        }
        for(int i = 0 ; i < Y.length() ; i++){
            y_map.put(Y.charAt(i), y_map.getOrDefault(Y.charAt(i), 0)+1);
        }

        TreeMap<Character, Integer> map = new TreeMap<>();
        for(char c = '0' ; c <= '9' ; c++){
            if(x_map.containsKey(c) && y_map.containsKey(c)){
                map.put(c, Math.min(x_map.get(c), y_map.get(c)));
            }
        }

        String answer;
        List<Character> list = new ArrayList<>();
        if(map.size() == 1 && map.containsKey('0')){
            answer = "0";
        }else{
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                while(entry.getValue() > 0){
                    list.add(entry.getKey());
                    entry.setValue(entry.getValue()-1);
                }
            }
            Collections.sort(list, Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < list.size(); i++){
                sb.append(list.get(i));
            }

            if(list.isEmpty()){
                answer = "-1";
            }else{
                answer = sb.toString();
            }
        }

        return answer;
    }

    // Gemini 개선 풀이
    // 기본이 최강의 무기다 : 빈도수 찾기
    public String solutionGemini(String X, String Y) {
        // 1. 메모리와 속도 효율이 좋은 int 배열 사용 (인덱스 0~9가 숫자 0~9에 대응)
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        // 2. 각 문자열의 숫자 빈도수 체크 (O(N))
        for (int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        // 3. 가장 큰 수를 만들기 위해 '9'부터 '0'까지 역순으로 순회 (정렬 불필요)
        for (int i = 9; i >= 0; i--) {
            // 두 문자열에서 공통으로 등장한 횟수 중 작은 값만큼 추가
            int commonCount = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < commonCount; j++) {
                sb.append(i);
            }
        }

        // 4. 예외 처리
        String answer = sb.toString();

        if (answer.equals("")) {
            return "-1"; // 공통된 숫자가 없는 경우
        }
        
        if (answer.charAt(0) == '0') {
            return "0"; // "00", "000" 처럼 0으로만 구성된 경우
        }

        return answer;
    }
}
