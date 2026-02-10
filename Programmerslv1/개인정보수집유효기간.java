package Programmerslv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 개인정보수집유효기간 {
    // 나의 풀이
    // 날짜 일수 계산 로직이 반복됨
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length ; i++){
            st = new StringTokenizer(terms[i]);
            String type = st.nextToken();
            int term = Integer.parseInt(st.nextToken());
            map.put(type, term);
        }

        st = new StringTokenizer(today, ".");
        int todayyy = Integer.parseInt(st.nextToken());
        int todaymm = Integer.parseInt(st.nextToken());
        int todaydd = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(privacies.length);
        for(int i = 0 ; i < privacies.length ; i++){
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            String type = st.nextToken();

            st = new StringTokenizer(date, ".");
            int yyyy = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int dd = Integer.parseInt(st.nextToken());

            mm += map.get(type);

            int dt = yyyy*12*28 + mm*28 + dd;
            int td = todayyy*12*28 + todaymm*28 + todaydd;
            if(dt <= td){
                list.add(i+1);
            }
        }

        int [] answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    // Gemini 개선 풀이
    public int[] solutionGemini(String today, String[] terms, String[] privacies) {
        // 1. 약관 정보를 Map에 저장
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            String type = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());
            termMap.put(type, duration);
        }

        // 2. 오늘 날짜를 일수로 변환 (반복문 밖에서 1회 계산)
        int todayDays = dateToDays(today);

        List<Integer> resultList = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String dateStr = st.nextToken();
            String type = st.nextToken();

            // 3. 수집 일자를 일수로 변환 + 유효기간(달 -> 일) 더하기
            int collectedDays = dateToDays(dateStr);
            int termDays = termMap.get(type) * 28; // 한 달은 28일
            
            // 만료 기준일 = 수집일 + 유효기간
            // (이 날짜부터는 파기해야 함. 즉, today가 이 값 이상이면 파기)
            int expirationDays = collectedDays + termDays;

            if (todayDays >= expirationDays) {
                resultList.add(i + 1);
            }
        }

        // 4. 결과 반환
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    // [핵심] 날짜 문자열을 총 일수로 변환하는 함수 분리
    private int dateToDays(String date) {
        StringTokenizer st = new StringTokenizer(date, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        // (연 * 12 * 28) + (월 * 28) + 일
        return (year * 12 * 28) + (month * 28) + day;
    }
}
