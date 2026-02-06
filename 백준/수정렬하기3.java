package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기3 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] count = new int[10001];
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < 10001  ; i++){
            for(int j = 0 ; j < count[i] ; j++){
                if(count[i] > 0){
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    // Gemini 개선풀이
    // StringBuilder는 엄청난 크기의 문자열을 가지고 있으면 메모리 초과가 발생할 수 있음 => BufferedWriter 대체
    public static void solutionGemini(String[] args) throws IOException {
        // 입력 속도를 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 출력 속도와 메모리 절약을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        // 문제 조건: 수는 10,000보다 작거나 같은 자연수
        // 0번 인덱스는 안 쓰더라도 가독성을 위해 크기를 넉넉히 잡음
        int[] count = new int[10001]; 
        
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }
        
        br.close(); // 입력 스트림 닫기
        
        for (int i = 1; i < 10001; i++) {
            // 해당 숫자가 나온 횟수만큼 반복 출력
            // BufferedWriter는 내부 버퍼가 차면 자동으로 flush(출력)하여 메모리를 아뀝니다.
            while (count[i] > 0) {
                bw.write(String.valueOf(i));
                bw.newLine();
                count[i]--;
            }
        }
        
        bw.flush(); // 남아있는 데이터 모두 출력
        bw.close(); // 출력 스트림 닫기
    }
}
