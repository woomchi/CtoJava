package 백준;
import java.io.*;

class 소인수분해{
    // 나의 풀이
    // 정확성을 좋지만, 큰 수가 주어지면 시간 복잡도가 커짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N ; i++){
            while(N%i == 0){
                N /= i;
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이
    // 제곱근까지 찾고 남은 수은 소수이기 때문에 그 수 자체를 넣음
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N의 범위가 클 경우를 대비해 long을 쓰는 습관도 좋지만, 
        // 11653번 기준으로는 int로 충분합니다.
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // [핵심 변경] i * i <= N 까지만 반복 (O(sqrt(N)))
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }

        // [핵심 변경] 반복문 종료 후 N이 1보다 크다면, 
        // 그 남은 수는 소수이므로 출력에 추가
        if (N > 1) {
            sb.append(N).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}