package Programmerslv1;

import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {
    /* 핵심 로직 : 투 인덱스로 비교 */

    // 나의 풀이
    // peek 두번 호출
    // 문제 특성에는 부합하지만, 실무적으로는 Queue보다는 인덱스로 구현함
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();
        for(String s: cards1){
            que1.add(s);
        }
        for(String s: cards2){
            que2.add(s);
        }


        for(String g : goal){
            if(que1.peek()!=null && (que1.peek()).equals(g)){
                que1.remove();
            }else if(que2.peek()!=null && (que2.peek()).equals(g)){
                que2.remove();
            }else{
                return "No";
            }
        }
        return "Yes";
    }

    // 나의 리펙터링 - Gemini의 피드백 반영
    // 두 인덱스가 포인터 역할을 하여 인스턴스를 추가로 생성하지 않아 메모리 측면에서 절약됨
    public String solutionRefactoring(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for(String g : goal){
            if(index1 < cards1.length && cards1[index1].equals(g)){
                index1++;
            }else if(index2 < cards2.length && cards2[index2].equals(g)){
                index2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
