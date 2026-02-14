package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 이항계수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        long numer = factorial(N);
        long denom = factorial(K) * (factorial(N-K));
        System.out.println(numer / denom);
        br.close();
    }
    
    public static long factorial(int n){
        if(n <= 1)    return 1;
        return n * factorial(n-1);
    }

    // Gemini 개선 풀이 - 약분을 통한 계산 간편화
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // BigInteger 사용
        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        // n! / (n-k)! 부분 계산 (약분 효과)
        for (int i = 0; i < K; i++) {
            n1 = n1.multiply(BigInteger.valueOf(N - i));
            n2 = n2.multiply(BigInteger.valueOf(i + 1));
        }

        System.out.println(n1.divide(n2));
    }

    // Gemini 개선 풀이 - 파스칼 삼각 공식
    static int[][] dp;
    
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        // 메모이제이션을 위한 배열
        dp = new int[N + 1][K + 1];
        
        System.out.println(combination(N, K));
    }

    public static int combination(int n, int k) {
        // 이미 계산된 값이면 반환
        if (dp[n][k] > 0) return dp[n][k];
        
        // 기본 성질: nCn = 1, nC0 = 1
        if (k == 0 || n == k) return dp[n][k] = 1;
        
        // 파스칼의 삼각형 공식 + (필요시 여기에 % 연산 추가)
        return dp[n][k] = combination(n - 1, k - 1) + combination(n - 1, k);
    }
}
