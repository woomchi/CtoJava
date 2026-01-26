package 백준;
import java.io.*;

public class 최댓값배열 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        
        String input = br.readLine();
        for(int count = 1; input!=null; count++){
            if(maxValue<Integer.parseInt(input)){
                maxValue = Integer.parseInt(input);
                maxIndex = count;
            }
            input = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append("\n").append(maxIndex);
        System.out.println(sb.toString());
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        // try-with-resources 구문 사용 (자동 close)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = 0; // 인덱스는 0으로 초기화해도 무방
            
            String input;
            int count = 1;
            
            // 한 줄씩 읽기
            while ((input = br.readLine()) != null) {
                // 빈 줄이 들어올 경우를 대비한 방어 코드 (선택 사항)
                if (input.trim().isEmpty()) {
                    continue;
                }

                // 1. 파싱은 한 번만 수행
                int currentValue = Integer.parseInt(input.trim()); // trim()으로 공백 제거 안전장치

                // 2. 최댓값 갱신 로직
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    maxIndex = count;
                }
                count++;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(maxValue).append("\n").append(maxIndex);
            System.out.println(sb);
        }
    }
}
