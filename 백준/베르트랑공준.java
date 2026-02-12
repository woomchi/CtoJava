package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 베르트랑공준 {
    // 나의 풀이
    // 매번 배열을 생성해야 한다는 단점이 있음(매우 비효율적)
    // 매번 새로운 배열을 생성하기 때문에 잘못하면 메모리 초과가 발생할 수 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while((n = Integer.parseInt(br.readLine()))!= 0){
            boolean [] isPrime = new boolean[n*2 + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;    isPrime[1] = false;
            for(int i = 2 ; i*i <= 2*n; i++){
                if(isPrime[i]){
                    for(int j = i*i ; j <= 2*n ; j+= i){
                        isPrime[j] = false;
                    }
                }
            }
            
            int count = 0;
            for(int i = n+1 ; i <= n * 2 ; i++){
                if(isPrime[i]){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이 - 배열 생성 효율 개선
    static final int MAX_N = 123456;
    static final int MAX_RANGE = MAX_N * 2;
    
    // 배열을 전역(static)으로 선언하여 한 번만 생성
    static boolean[] isPrime = new boolean[MAX_RANGE + 1];

    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 에라토스테네스의 체: 프로그램 시작 시 '한 번만' 수행 (Precomputation)
        setupPrimes();

        int n = 0;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            
            // 2. 미리 구해둔 배열에서 조회만 수행
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void setupPrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // 제곱근까지만 반복
        for (int i = 2; i * i <= MAX_RANGE; i++) {
            if (isPrime[i]) {
                // i의 배수들을 지움 (i*i 부터 시작하는 최적화 적용 유지)
                for (int j = i * i; j <= MAX_RANGE; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
