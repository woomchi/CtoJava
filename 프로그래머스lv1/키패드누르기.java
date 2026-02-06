package 프로그래머스lv1;

import java.util.ArrayList;
import java.util.List;

public class 키패드누르기 {
    /* 핵심 로직 : 나머지로 키패드 종류 인식 + x와y거리 합으로 거리 비교 */

    // 나의 풀이
    // 거리 계산을 List로 하면서 잘못된 계산이 발생할 수 있음(인덱스 실수)
    // 변수명들이 '_'를 사용하는데 이보다 하나의 단어로 쓰는게 나음
    public String solution(int[] numbers, String hand) {
        final int L_INIT = -1;
        final int R_INIT = -1;

        List<Integer> left  = new ArrayList<>();
        List<Integer> mid  = new ArrayList<>();
        List<Integer> right  = new ArrayList<>();  
        left.add(L_INIT);   left.add(7);        left.add(4);    left.add(1);
        mid.add(0);         mid.add(8);         mid.add(5);     mid.add(2);
        right.add(R_INIT);  right.add(9);      right.add(6);   right.add(3);

        int l_pos = L_INIT;     int r_pos = R_INIT;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < numbers.length ; i++){
            if(left.contains(numbers[i])){
                l_pos = numbers[i];
                sb.append('L');
            }else if(right.contains(numbers[i])){
                r_pos = numbers[i];
                sb.append('R');
            }else{
                int l_distance;     int r_distance;
                if(mid.contains(l_pos)){
                    l_distance = Math.abs(mid.indexOf(numbers[i]) - mid.indexOf(l_pos)) - 1;
                }else{
                    l_distance = Math.abs(mid.indexOf(numbers[i]) - left.indexOf(l_pos));
                }
                if(mid.contains(r_pos)){
                    r_distance = Math.abs(mid.indexOf(numbers[i]) - mid.indexOf(r_pos)) - 1;
                }else{
                    r_distance = Math.abs(mid.indexOf(numbers[i]) - right.indexOf(r_pos));
                }

                if(l_distance < r_distance){
                    l_pos = numbers[i];
                    sb.append('L');
                }else if(l_distance > r_distance){
                    r_pos = numbers[i];
                    sb.append('R');
                }else{
                    if(hand.equals("left")){
                        l_pos = numbers[i];
                        sb.append('L');
                    }else{
                        r_pos = numbers[i];
                        sb.append('R');
                    }
                }
            }
        }
        return sb.toString();
    }

    // Gemini 개선 풀이
    // x 거리와 y거리의 절댓값 합으로 거리 계산 차이가 발생하지 않음
    public String solutionGemini(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftPos = 10;  // '*' 위치
        int rightPos = 12; // '#' 위치
        
        for (int num : numbers) {
            if (num == 0) num = 11; // 0을 11로 취급하여 계산 용이하게 함
            
            // 1. 무조건 왼손/오른손인 경우
            if (num % 3 == 1) { // 1, 4, 7
                sb.append("L");
                leftPos = num;
            } else if (num % 3 == 0) { // 3, 6, 9 (11인 0 제외, 10, 12 제외)
                sb.append("R");
                rightPos = num;
            } else { // 2, 5, 8, 0(11) -> 중앙
                int leftDist = getDistance(leftPos, num);
                int rightDist = getDistance(rightPos, num);
                
                // 이 부분은 내 풀이와 동일(단지, 인덱스 계산에서 발생하는 실수를 방지하는 로직으로 리펙터링한 것)
                if (leftDist < rightDist) {
                    sb.append("L");
                    leftPos = num;
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    rightPos = num;
                } else { // 거리가 같을 때
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftPos = num;
                    } else {
                        sb.append("R");
                        rightPos = num;
                    }
                }
            }
        }
        return sb.toString();
    }
    
    // 맨해튼 거리 계산: |x1-x2| + |y1-y2|
    private int getDistance(int start, int target) {
        // 좌표 변환 (숫자-1)/3 은 행, (숫자-1)%3 은 열
        // 편의상 start, target은 1~12 사이의 값으로 보정되어 들어옴
        int r1 = (start - 1) / 3;
        int c1 = (start - 1) % 3;
        int r2 = (target - 1) / 3;
        int c2 = (target - 1) % 3;
        
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
