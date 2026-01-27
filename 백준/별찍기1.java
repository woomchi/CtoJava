package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기1 {
    // 나의 풀이
    // 다 좋은데 시간 복잡도가 큼
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        // try-with-resources를 사용하면 close()를 수동으로 안 해도 되어 더 안전합니다.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            
            for (int i = 1; i <= N; i++) {
                // 안쪽 루프 대신 repeat() 사용 가능
                sb.append("*".repeat(i)).append("\n");
            }
            
            System.out.print(sb);
        } catch (NumberFormatException e) {
            System.err.println("숫자만 입력 가능합니다.");
        }
    }
}
