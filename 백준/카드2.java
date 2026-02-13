package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2 {
    // 나의 풀이
    // => 정석 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++){
            queue.add(i);
        }
        
        while(queue.size() != 1){
            queue.remove();
            queue.add(queue.remove());
        }
        System.out.println(queue.peek());
        br.close();
    }

    // Gemini 개선 풀이 - 수학적 공식화
    // 처음 한 바퀴로 돌면 짝수만이 남음 => 해당 시점에서 맨 뒤의 숫자가 결국 남게됨
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 1. N보다 작은 가장 큰 2의 거듭제곱(K) 찾기
        int K = 1;
        
        // K가 N보다 작을 때까지 계속 2를 곱함
        // 예: N=6이면, K는 1 -> 2 -> 4 (멈춤, 다음은 8이니까)
        while (K * 2 < N) {
            K *= 2;
        }
        
        if (N == 1) { // 1은 예외 처리 (혹은 위 로직에 포함되게 짤 수도 있음)
            System.out.println(1);
        } else {
            // 공식: 2 * (N - K)
            System.out.println(2 * (N - K));
        }
        
        br.close();
    }
}
