package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 최소최대 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstValue = Integer.parseInt(st.nextToken());
        int maxValue = firstValue;
        int minValue = firstValue;
        
        for(int i=0; i < N-1; i++){
            int val = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, val);
            minValue = Math.min(minValue, val);
        }
        
        System.out.println(minValue+" "+maxValue);
        br.close();
    }

    // Gemini 또 다른 풀이
    // N이 0일 때 예외처리가 자동으로 됨
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정수의 최소/최대 범위값으로 초기화
        int maxValue = Integer.MIN_VALUE; // -21억... (가장 작은 수로 설정해둬야 들어오는 값이 무조건 더 큼)
        int minValue = Integer.MAX_VALUE; // +21억... (가장 큰 수로 설정해둬야 들어오는 값이 무조건 더 작음)

        for(int i = 0; i < N; i++) { // 0부터 N까지 다 돔
            int val = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, val);
            minValue = Math.min(minValue, val);
        }
        
        System.out.println(minValue+" "+maxValue);
        br.close();
    }
}
