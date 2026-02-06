package 프로그래머스lv1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    // 나의 풀이
    // isEmpty를 쓸 이유가 없음..(list.add(arr[0])) 이기 때문에
    // index를 따로 관리하는 것은 가독성 측면에서 아쉬움
    // 따라서, 현재 상태를 알려주는 list.size()로 가장 최근 요소를 list.size()-1로 확인할 수 있음
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        int index = 0;
        list.add(arr[0]);
        for(int i = 1 ; i < arr.length ; i++){
            if(!list.isEmpty()){
                if(arr[i] != list.get(index)){
                    list.add(arr[i]);
                    index++;
                }
            } 
        }
        int [] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 다른 사람 풀이
    public int[] solutionOther(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }

    // Gemini 개선 풀이
    public int[] solutionGemini(int[] arr) {
        // 결과를 담을 리스트 (크기를 미리 지정하면 성능 향상)
        List<Integer> list = new ArrayList<>(arr.length);
        
        // 향상된 for문 사용 (인덱스 직접 제어보다 안전하고 가독성이 좋음)
        for (int num : arr) {
            // 1. 리스트가 비어있거나 (첫 번째 요소)
            // 2. 리스트의 마지막 요소(가장 최근에 넣은 값)와 현재 값이 다르면 추가
            if (list.isEmpty() || list.get(list.size() - 1) != num) {
                list.add(num);
            }
        }

        // 리스트를 배열로 변환
        // (Java 8 스트림보다 반복문 복사가 속도는 더 빠릅니다)
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
