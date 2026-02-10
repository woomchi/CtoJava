package Programmerslv1;

import java.time.LocalDate;

public class 요일구하기 {   // 프로그래머스 '2016' 문제
    /* 핵심 로직 : 각 날짜 날수를 매핑하여 활용 */

    // 나의 풀이
    // 달력 날짜를 암호화로 표현하면 조건문으로 다시 확인해야해서 비효율적임
    // 마찬가지로 요일을 확인할 때도 switch문을 사용하면 많이 복잡함
    public String solution(int a, int b) {
        int [] calendar = {2,0,2,1,2,1,2,2,1,2,1,2};
        int days = 0;
        for(int i = 1; i < a ; i++){
            if(calendar[i-1] == 2){
                days += 31;
            }else if(calendar[i-1] == 1){
                days += 30;
            }else if(calendar[i-1] == 0){
                days += 29;
            }
        }
        days += b-1;

        StringBuilder sb = new StringBuilder();
        switch(days%7){
            case 0:
                sb.append("FRI");
                break;
            case 1:
                sb.append("SAT");
                break;
            case 2:
                sb.append("SUN");
                break;
            case 3:
                sb.append("MON");
                break;
            case 4:
                sb.append("TUE");
                break;
            case 5:
                sb.append("WED");
                break;
            case 6:
                sb.append("THU");
                break;
        }
        return sb.toString();
    }

    // Gemini 개선 풀이 - 리펙터링
    public String solutionGemini(int a, int b) {
        // 1. 각 월의 날짜수를 직접 저장 (윤년인 2016년 기준)
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // 2. 요일 이름을 배열로 관리 (금요일 시작 기준)
        String[] dayNames = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        // 3. 지난 달까지의 날짜 수 합산
        int totalDays = 0;
        for (int i = 0; i < a - 1; i++) {
            totalDays += daysInMonth[i];
        }
        
        // 4. 이번 달의 날짜 더하고 인덱스 보정 (-1)
        totalDays += b - 1;
        
        // 5. 배열 인덱스로 바로 접근하여 반환
        return dayNames[totalDays % 7];
    }
    
    // Gemini 개선 풀이 - 라이브러리 활용
    public String solutionGemini1(int a, int b) {
        // 2016년 a월 b일의 날짜 객체 생성
        LocalDate date = LocalDate.of(2016, a, b);
        
        // 요일 가져오기 (MONDAY, TUESDAY...)
        // 문제 요구사항에 맞춰 앞 3글자만 따오기
        return date.getDayOfWeek().toString().substring(0, 3);
    }
}
