package 프로그래머스lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 가장많이받은선물 {
    // 나의 풀이
    // 유틸리티 클래스 사용 과다로 시간 효율성 저하
    // 매직 넘버 사용
    // 디버깅 중에 제거하지 않은 불필요한 로직
    public int solution(String[] friends, String[] gifts) {
        final int LOGNUM = 3;
        HashMap<String, Integer> giftLog = new HashMap<>();
        HashMap<String, Integer> friendList = new HashMap<>();
        for(int i = 0 ; i < friends.length ; i++){
            friendList.put(friends[i], i);
        }

        int [][] giveTake = new int[friends.length][LOGNUM];
        // 상호 간 주거나 받은 횟수 기록
        for(String g : gifts){
            giftLog.put(g, giftLog.getOrDefault(g, 0)+1);

            StringTokenizer st = new StringTokenizer(g);
            String A = st.nextToken();
            String B = st.nextToken();
            giveTake[friendList.get(A)][0]++;
            giveTake[friendList.get(B)][1]++;
        }

        // 선물 지수
        for(int i = 0 ; i < friends.length ; i++){
            giveTake[i][2] = giveTake[i][0] - giveTake[i][1];
        }

        int [] nextMonth = new int[friends.length];
        for(int i = 0 ; i < friends.length ; i++){
            for(int j = i+1 ; j < friends.length ; j++){
                String A = friends[i];
                String B = friends[j];
                if(A == B)  continue;
                // A -> B
                int AB = 0;
                StringBuilder sb = new StringBuilder();
                sb.append(A).append(" ").append(B);
                if(giftLog.containsKey(sb.toString())){
                    AB = giftLog.get(sb.toString());
                }

                // B -> A
                int BA = 0;
                sb = new StringBuilder();
                sb.append(B).append(" ").append(A);
                if(giftLog.containsKey(sb.toString())){
                    BA = giftLog.get(sb.toString());
                }

                // A와 B의 선물 이력 및 선물 지수 비교
                if(AB > BA){
                    nextMonth[friendList.get(A)]++;
                }else if(AB < BA){
                    nextMonth[friendList.get(B)]++;                    
                }else{
                    if(giveTake[friendList.get(A)][2] > giveTake[friendList.get(B)][2]){
                        nextMonth[friendList.get(A)]++;
                    }else if(giveTake[friendList.get(A)][2] < giveTake[friendList.get(B)][2]){
                        nextMonth[friendList.get(B)]++;
                    }
                }
            }
        }

        Arrays.sort(nextMonth);
        // for(int i = 0; i < nextMonth.length ; i++){
        //     System.out.println(nextMonth[i]);
        // }
        return nextMonth[nextMonth.length-1];
    }
    
    // Gemini 개선 풀이 - Map대신 2차원 배열 활용
    // 친구 수가 100이하이기 때문에 굳이 Map을 활용할 필요없음
    // 그리고 Map 때문에 문자 재조합 비교하는게 불필요한 타자 양을 늘림
    // 결정적으로 i->j에 대한 2차원 배열로 만들면 비교 로직도 간소화됨
    public int solutionGemini(String[] friends, String[] gifts) {
        int n = friends.length;
        
        // 1. 친구 이름을 인덱스로 매핑 (검색 속도 O(1))
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        // 2. 자료구조 정의 (인접 행렬 & 선물 지수)
        int[][] record = new int[n][n]; // [준사람][받은사람] = 개수
        int[] giftDegree = new int[n];  // 선물 지수 (준거 - 받은거)
        
        // 3. 기록 처리
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = map.get(parts[0]);
            int receiver = map.get(parts[1]);
            
            record[giver][receiver]++;
            
            // 선물 지수 실시간 갱신 (준 사람 +1, 받은 사람 -1)
            giftDegree[giver]++;
            giftDegree[receiver]--;
        }
        
        // 4. 다음 달 받을 선물 계산
        int maxGift = 0;
        
        for (int i = 0; i < n; i++) {
            int count = 0; // i가 받을 선물의 수
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                // i가 j에게 준 게 더 많거나, 
                // 기록이 같으면서(0포함) 선물 지수가 i가 더 높을 때
                if (record[i][j] > record[j][i] || 
                (record[i][j] == record[j][i] && giftDegree[i] > giftDegree[j])) {
                    count++;
                }
            }
            maxGift = Math.max(maxGift, count);
        }
        
        return maxGift;
    }
}
