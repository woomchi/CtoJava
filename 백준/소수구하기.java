package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
    // 나의 풀이
    // 범위가 100만이라 크다고 생각해서 제곱근 방식을 사용함
    // 다만 걱정할 정도는 아니라 이보다 큰 범위를 가질 때 사용하면 좋은 방법임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i = start ; i <= end ; i++){
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb);
        br.close();
    }
    
    public static boolean isPrime(int num){
        if(num <= 1)    return false;    
        for(int i = 2 ; i*i <= num ; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    // Gemini 개선 풀이 - 복습 차원
    public static boolean[] isNotPrime = new boolean[1000001];

    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        // 1. 에라토스테네스의 체 초기화
        getPrime(end);
        
        StringBuilder sb = new StringBuilder();
        
        // 2. 범위 내의 소수 출력
        for(int i = start; i <= end; i++) {
            // isNotPrime[i]가 false이면 소수 (단, 1은 제외)
            if(!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb);
        br.close();
    }
    
    public static void getPrime(int n) {
        // 0과 1은 소수가 아님
        isNotPrime[0] = isNotPrime[1] = true;
        
        // 2부터 n의 제곱근까지 반복
        for(int i = 2; i * i <= n; i++) {
            // 이미 지워진 수(소수가 아닌 수)라면 건너뜀
            if(isNotPrime[i]) continue;
            
            // i가 소수라면, i의 배수들을 모두 지움 (소수가 아님으로 표시)
            // j = i * i 부터 시작하는 것이 최적화 포인트 (그 이전 배수는 이미 지워졌음)
            for(int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}
