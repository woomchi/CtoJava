package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위세개 {
    // 나의 풀이
    // 논리적으로 문제는 없지만, 가독성 측면(실무)에서는 아쉬움
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        
        int result = 0;
        if(num1 == num2){
            if(num2 == num3){
                result = 10000 + num1 * 1000;
            }else{
                result = 1000 + num1 * 100;
            }
        }else{
            if(num1 == num3 || num2 == num3){
                result = 1000 + num3 * 100;
            }else{
                result = Math.max(num1, Math.max(num2, num3)) * 100;
            }
        }
        System.out.println(result);
    }

    // Gemini 개선 풀이
    // 정렬함으로써 첫 번째와 마지막이 같으면 셋다 같은 수
    // 짝이 같으면 둘만 같은수
    // 아니면 모두 다른 수로 판별할 수 있음
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        
        int[] dice = {num1, num2, num3};
        Arrays.sort(dice); // 작은 순서대로 정렬됨 [0] <= [1] <= [2]

        // 정렬이 되었으므로 가장 큰 수는 무조건 dice[2] 입니다.
        // 로직이 확 단순해집니다.

        if (dice[0] == dice[2]) { // 첫번째와 마지막이 같으면? 셋 다 같은 수
            System.out.println(10000 + dice[0] * 1000);
        } else if (dice[0] == dice[1] || dice[1] == dice[2]) { // 두 개만 같은 경우
            // 정렬했기 때문에 같은 숫자는 반드시 붙어있습니다. 즉 dice[1]은 무조건 같은 숫자입니다.
            System.out.println(1000 + dice[1] * 100);
        } else { // 다 다른 경우
            System.out.println(dice[2] * 100); // 정렬했으니 맨 뒤가 무조건 제일 큼
        }
        br.close();
    }
}
