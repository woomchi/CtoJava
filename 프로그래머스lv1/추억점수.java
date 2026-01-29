package 프로그래머스lv1;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    // 나의 풀이
    // Hash Map에 대한 초기 용량을 지정하지 않으면 재할당이 필요할 때 메모리가 불필요하게 사용됨
    // index는 어차피 photo.length 크기이기 때문에 첫번째 반복문을 향상된 반복문이 아니라 i로 확인하는 방식이 나음
    // containsKey 메서드도 좋지만, getOrDefault로 하면 해당 key가 없을 때 지정한 값을 반환할 수 있음
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 각 인물에 대한 추억 점수 확인 => HashMap
        // 하나의 사진에 인물 추억 점수의 총합을 저장
        // 사진들의 추억 점수 총합을 배열로 반환
        HashMap<String, Integer> memory = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            memory.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        int index = 0;
        for(String[] p: photo){
            for(String person: p){
                if(memory.containsKey(person)){
                    answer[index] += memory.get(person);
                }
            }
            index++;
        }

        return answer;
    }

    // Gemini 개선 풀이 - getOrDefault 메서드 활용
    public int[] solutionGemini(String[] name, int[] yearning, String[][] photo) {
        // 1. HashMap 초기 용량 설정 (불필요한 Resizing 방지)
        Map<String, Integer> memory = new HashMap<>(name.length);
        
        for (int i = 0; i < name.length; i++) {
            memory.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        // 2. 인덱스 기반 루프로 변경 (외부 index 변수 제거)
        for (int i = 0; i < photo.length; i++) {
            for (String person : photo[i]) {
                // 3. getOrDefault로 null safe하게 처리 (없으면 0 더하기)
                answer[i] += memory.getOrDefault(person, 0);
            }
        }

        return answer;
    }
}
