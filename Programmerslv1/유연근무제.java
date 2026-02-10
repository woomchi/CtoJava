package Programmerslv1;

public class 유연근무제 {
    // 나의 풀이
    // 입력 받은 매개변수의 재사용성으로 인해 버그 발생
    // 굳이 boolean 없이 전체 수에서 차감하는 식이 더 간단함(가독성은 조금 떨어짐)
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        final int STAFFNUM = schedules.length;
        final int WEEK = 7;

        boolean [] isPass = new boolean[STAFFNUM];
        for(int i = 0 ; i < isPass.length ; i++){
            isPass[i] = true;
        }

        for(int i = 0 ; i < STAFFNUM ; i++){
            int attend = (schedules[i]/100)*60 + (schedules[i]%100) + 10;
            for(int j = 0 ; j < WEEK; j++){
                if((startday+j)%7 == 0 || (startday+j)%7 == 6){
                    continue;
                }
                int daylog = (timelogs[i][j]/100)*60 + (timelogs[i][j]%100);
                if(daylog > attend){
                    isPass[i] = false;
                    break;
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < isPass.length ; i++){
            if(isPass[i] == true)   answer++;            
        }

        return answer;
    }

    // 나의 리펙터링 - 다른 사람 방식 참고
    public int solution1(int[] schedules, int[][] timelogs, int startday) {
        final int STAFFNUM = schedules.length;
        final int WEEK = 7;

        int answer = schedules.length;

        for(int i = 0 ; i < STAFFNUM ; i++){
            int attend = (schedules[i]/100)*60 + (schedules[i]%100) + 10;
            for(int j = 0 ; j < WEEK; j++){
                if((startday+j)%7 == 0 || (startday+j)%7 == 6)  continue;
                int daylog = (timelogs[i][j]/100)*60 + (timelogs[i][j]%100);
                if(daylog > attend){
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}
