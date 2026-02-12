package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 골드바흐파티션 {
    static final int MAX_RANGE = 1000000;
    public static void main(String[] args) throws IOException {
        // 소수 판별
        boolean [] isPrime = new boolean[MAX_RANGE+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;    isPrime[1] = false;
        for(int i = 2 ; i*i <= MAX_RANGE ; i++){
            if(isPrime[i]){
                for(int j = i*i ; j <= MAX_RANGE ; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for(int A = 2 ; A < num ; A++){
                if(isPrime[A]){
                    int B = num - A;
                    if(isPrime[B] && A <= B)   count++;
                }
            }
            sb.append(count).append("\n");            
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이
    // n/2 까지만큼만 연산함으로써 효율성 향상
    // 결국 A<=B 인데, A<= N-A 이고 2A <= N 이면 A <= N/2 이기 때문에 N/2까지만 돌리면 됨
    // static final int MAX_RANGE = 1000000;
    
    public static void solutionGemini(String[] args) throws IOException {
        // 1. 에라토스테네스의 체 (기존 코드와 동일, 잘 작성하셨습니다!)
        boolean[] isPrime = new boolean[MAX_RANGE + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX_RANGE; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX_RANGE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력이 없을 수도 있는 경우를 대비해 예외처리나 조건 확인을 할 수도 있지만,
        // 백준 문제 형식상 readLine()이 null이 아닌 경우 바로 파싱합니다.
        int T = Integer.parseInt(br.readLine()); // 변수명 N보다는 Testcase의 T가 더 직관적일 수 있습니다.

        StringBuilder sb = new StringBuilder();
        
        // 2. 각 테스트 케이스 처리
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;

            // 핵심 수정 부분: 이중 for문을 단일 for문으로 변경
            // A + B = num 이므로, A는 num/2 까지만 검사하면 됩니다.
            // (예: 10일 때 3+7을 찾으면, 7+3은 찾을 필요 없음)
            for (int j = 2; j <= num / 2; j++) {
                if (isPrime[j]) {           // A가 소수이고
                    if (isPrime[num - j]) { // B(= num - A)도 소수이면
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}
