package 프로그래머스lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class 신고결과받기 {
    /* 핵심 로직 : 2차원 배열 => 개선 : 인접 행렬 */

    // 나의 풀이
    public int[] solution(String[] id_list, String[] report, int k) {
        // 16:29
        final int IDNUM = id_list.length;
        HashMap<String, Integer> id = new HashMap<>();
        for(int i = 0 ; i < IDNUM ; i++){
            id.put(id_list[i], i);
        }

        int[][] reportlog = new int[IDNUM][IDNUM];
        int [] count = new int[IDNUM];
        for(int i = 0 ; i < report.length ; i++){
            String[] reported = report[i].split(" ");
            if(reportlog[id.get(reported[0])][id.get(reported[1])] != 1){
                count[id.get(reported[1])]++;
            }
            reportlog[id.get(reported[0])][id.get(reported[1])] = 1;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < count.length ; i++){
            if(count[i] >= k){
                list.add(i);
            }
        }

        int [] answer = new int[IDNUM];
        for(int i = 0 ; i < reportlog.length ; i++){
            for(int target : list){
                if(reportlog[i][target] == 1){
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    // Gemini 개선 풀이
    public int[] solutionGemini(String[] id_list, String[] report, int k) {
        // 1. 중복 신고 제거를 위해 HashSet 사용
        // (한 사람이 같은 사람을 여러 번 신고해도 1번으로 처리)
        HashSet<String> uniqueReport = new HashSet<>(Arrays.asList(report));
        
        // 2. 데이터 구조 초기화
        // key: 신고 당한 사람, value: 신고한 사람들의 목록 (누가 신고했는지 알아야 메일을 보내므로)
        Map<String, ArrayList<String>> reportedMap = new HashMap<>();
        
        // key: 유저 이름, value: 정답 배열 인덱스 (마지막에 정답 배열을 쉽게 만들기 위함)
        Map<String, Integer> idIdx = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIdx.put(id_list[i], i);
        }

        // 3. 신고 기록 처리
        for (String rep : uniqueReport) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];  // 신고자
            String target = parts[1];    // 신고 당한 자

            // 신고 당한 사람 기준, 나를 신고한 사람 리스트에 추가
            // getOrDefault 대신 putIfAbsent 등을 활용하거나, 체크 후 생성
            if (!reportedMap.containsKey(target)) {
                reportedMap.put(target, new ArrayList<>());
            }
            reportedMap.get(target).add(reporter);
        }

        // 4. 메일 발송 횟수 계산
        int[] answer = new int[id_list.length];
        
        for (String key : reportedMap.keySet()) {
            ArrayList<String> reporters = reportedMap.get(key);
            
            // 신고 횟수가 k번 이상인 경우에만
            if (reporters.size() >= k) {
                // 신고한 사람들에게 메일 발송 (+1)
                for (String reporter : reporters) {
                    answer[idIdx.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}
