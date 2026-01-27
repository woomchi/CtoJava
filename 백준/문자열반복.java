package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {
    // 나의 풀이
    // 반복 횟수를 repeat 메서드로 대체하면 더 간결함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int k = 0 ; k < str.length() ; k++){
                for(int j = 0 ; j < M ; j++){
                    sb.append(str.charAt(k));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            
            // 문자열의 각 문자를 순회
            for (int k = 0; k < str.length(); k++) {
                sb.append(String.valueOf(str.charAt(k)).repeat(M));
            }
            sb.append("\n");
        }
        // println 대신 print 사용 (마지막 불필요한 개행 방지)
        System.out.print(sb);
    }
}
