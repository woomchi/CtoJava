package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 평균 {
    // 나의 풀이
    // 배열없이 반복문 한번으로 평균을 구하기 전의 합을 더하고 
    // 이를 마지막에 새로운 평균 구하는 방법을 적용하면 더 간결한 코드가 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        double [] score = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double M = Double.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            double num = Double.parseDouble(st.nextToken());
            score[i] = num;
            if(M < num)    M = num;
        }
        
        double average = 0;
        for(int i = 0 ; i < N ; i++){
            score[i] = (score[i]/M) * 100;
            average += score[i];
        }
        average /= N;
        
        System.out.println(average);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N은 입력만 받고 루프 횟수로만 사용하므로 변수에 저장하지 않아도 되지만, 
        // 수식 계산을 위해 저장합니다.
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double sum = 0;
        double max = 0; // 점수는 0보다 크거나 같으므로 0으로 초기화해도 무방
        
        for(int i = 0; i < N; i++) {
            double num = Double.parseDouble(st.nextToken());
            
            // 최댓값 갱신
            if(num > max) max = num;
            
            // 배열 저장 없이 바로 합계 누적
            sum += num;
        }
        
        // 분배 법칙을 역으로 적용하여 마지막에 한 번만 계산
        // (총합 * 100) / (최댓값 * N)
        System.out.println((sum * 100.0) / (max * N));
        
        br.close();
    }
}
