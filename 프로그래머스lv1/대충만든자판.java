package 프로그래머스lv1;
import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    // 나의 풀이
    // 매번 keymap을 순회하는 중복 연산이 실행되기 때문에 대용량 데이터를 다룰 때 시간초과될 가능성이 높음
    public int[] solution(String[] keymap, String[] targets) {
        int len = targets.length;
        int [] count = new int[len];
        for(int i = 0 ; i < len; i++){
            count[i] = targetCount(keymap, targets[i]);
        }
        return count;
    }
    
    public int targetCount(String[] keymap, String currentTarget){
        int countSum = 0;
        for(int j = 0 ; j < currentTarget.length(); j++){
            int minKey = getMinCount(keymap, currentTarget.charAt(j));
            if(minKey == Integer.MAX_VALUE){
                return -1;
            }else{
                countSum += minKey+1;
            }
        }
        return countSum;
    }
    
    public int getMinCount(String [] keymap ,char ch){
        int minKey = Integer.MAX_VALUE;
        for(int k = 0 ; k < keymap.length; k++){
            int index = keymap[k].indexOf(ch);
            if(index == -1) continue;
            minKey = Math.min(minKey, index);
        }
        return minKey;
    }

    // Gemini 개선 풀이
    // 존재하는 keymap 요소의 최소 도달 횟수를 Map에 저장하고 이를 추후에 다루는 방식
    public int[] solutionGemini(String[] keymap, String[] targets) {
        // 1. 각 문자를 누르기 위한 최소 횟수를 저장할 Map 생성 (전처리)
        Map<Character, Integer> minPressCheck = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int pressCount = i + 1; // 0번 인덱스는 1번 누른 것
                
                // 이미 저장된 횟수보다 더 적게 눌러서 도달 가능하다면 갱신, 없으면 저장
                // map.getOrDefault를 쓰지 않고 효율적으로 갱신
                if (!minPressCheck.containsKey(c) || pressCount < minPressCheck.get(c)) {
                    minPressCheck.put(c, pressCount);
                }
            }
        }

        // 2. targets 순회하며 결과 계산
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int countSum = 0;
            boolean possible = true;

            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                
                // 키맵에 없는 문자가 나오면 즉시 -1 처리
                if (!minPressCheck.containsKey(c)) {
                    possible = false;
                    break;
                }
                countSum += minPressCheck.get(c);
            }

            answer[i] = possible ? countSum : -1;
        }

        return answer;
    }
}
