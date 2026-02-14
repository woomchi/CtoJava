import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            BigInteger n1 = BigInteger.ONE;
            BigInteger n2 = BigInteger.ONE;
            for(int j = 0 ; j < K ; j++){
                n1 = n1.multiply(BigInteger.valueOf(M-j));
                n2 = n2.multiply(BigInteger.valueOf(j+1));
            }
            sb.append(n1.divide(n2)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이 - 파스칼 삼각 공식
    static int[][] dp = new int[31][31];

    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // DP 테이블 미리 채우기 (파스칼의 삼각형)
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1;      // nC0 = 1
            dp[i][i] = 1;      // nCn = 1
            for (int j = 1; j < i; j++) {
                // nCr = n-1Cr-1 + n-1Cr
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 미리 계산된 값에서 바로 출력 (O(1))
            sb.append(dp[M][K]).append('\n');
        }
        
        System.out.print(sb);
    }
}
