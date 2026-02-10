package Programmerslv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 데이터분석 {
    /* 핵심 로직 : 배열(int[]) 타입의 리스트 활용 */

    // 나의 풀이
    // 제네릭 타입에 배열이 되는 줄 몰랐음
    // Comparator 구현할 줄 몰라서 그냥 이중 반복문 버블 정렬 알고리즘 사용함
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ext 데이터에서 val_ext보다 작은 값을 뽑아냄
        // 이때 sort_by 를 기준으로 정렬됨
        final int type_n = 4;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);     map.put("date", 1);
        map.put("maximum", 2);  map.put("remain", 3);

        int num = 0;
        int index = map.get(ext);
        for(int i = 0 ; i < data.length ; i++){
            if(val_ext > data[i][index]){
                num++;
            }
        }

        int j = 0;
        int[][] answer = new int[num][type_n];
        for(int i = 0 ; i < data.length ; i++){
            if(val_ext > data[i][index]){                
                answer[j++] = data[i];
            }
        }

        index = map.get(sort_by);
        for(int i = 0 ; i < num-1 ; i++){
            for(int k = 0 ; k < num-1 ; k++){
                if(answer[k][index] > answer[k+1][index]){
                    int[] temp = answer[k];
                    answer[k] = answer[k+1];
                    answer[k+1] = temp;
                }
            }
        }

        return answer;
    }

    // Gemini 개선 풀이
    public int[][] solutionGemini(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. 컬럼명과 인덱스 매핑 (helper 메서드나 Map 사용)
        Map<String, Integer> colMap = new HashMap<>();
        colMap.put("code", 0);
        colMap.put("date", 1);
        colMap.put("maximum", 2);
        colMap.put("remain", 3);
        
        int filterIdx = colMap.get(ext);
        int sortIdx = colMap.get(sort_by);
        
        // 2. 필터링: ArrayList를 사용하여 한 번만 순회
        List<int[]> filteredList = new ArrayList<>();
        for (int[] row : data) {
            if (row[filterIdx] < val_ext) {
                filteredList.add(row);
            }
        }
        
        // 3. 정렬: 내장 Sort 사용 (Lambda 표현식 활용)
        // 오름차순 정렬: (o1, o2) -> o1[idx] - o2[idx]
        filteredList.sort((o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        // 4. List를 배열로 변환하여 반환
        return filteredList.toArray(new int[0][]);
    }
}
