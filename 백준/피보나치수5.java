package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5 {
    // 나의 풀이
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N == 0){
            System.out.println(0);
        }else if(N == 1){
            System.out.println(1);
        }else{
            int nMinus1 = 0;
            int n = 1;
            int sum = 0;
            for(int i = 1 ; i < N ; i++){
                sum = nMinus1 + n;
                nMinus1 = n;
                n = sum;
            }
            System.out.println(sum);
        }
        
        br.close();
    }

    // Gemini 개선 풀이
    public class Main {
        // 값을 저장할 배열 (N이 90까지 갈 수 있으므로 long 사용)
        // 함수 밖(static)에 선언하여 재귀 함수들이 공유하도록 함
        static long[] memo;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            // 배열 초기화 (0 ~ N번 인덱스까지 필요하므로 N+1 크기)
            memo = new long[N + 1];

            System.out.println(fib(N));
            
            br.close();
        }

        // 재귀 함수
        public static long fib(int n) {
            // [종료 조건 1] 0이나 1이면 값 그대로 반환
            if (n == 0) return 0;
            if (n == 1) return 1;

            // [중요] 이미 계산한 적이 있는 값인지 확인 (메모이제이션)
            // 자바에서 long 배열의 초기값은 0이므로, 0이 아니라는 뜻은 계산된 적이 있다는 뜻
            if (memo[n] != 0) {
                return memo[n];
            }

            // [재귀 호출] 값을 계산하고 -> 배열에 저장한 뒤 -> 반환
            memo[n] = fib(n - 1) + fib(n - 2);
            return memo[n];
        }
    }
}
