package 백준;
import java.io.*;

class 창문닫기{
    // 나의 풀이 => 잘못된 접근
    // 메모리 제약 크기가 작음 => 배열 생성하면 무조건 메모리 초과 발생함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 7
        // 1 2 3 4 5 6 7
        // 1 3 5 7
        // 1 5 6 7
        // 1 4 5 6 7
        // 1 4 6 7
        // 1 4 7
        // 1 4
        boolean [] window = new boolean[N+1];
        for(int i = 2 ; i <= N ; i++)    window[i] = true;
        for(int i = 2 ; i*i <= N ; i++){
            if(window[i]){
                for(int j = i*i ; j <= N ; j += i){
                    window[j] = false;
                }
            }
        }
        
        int count = 0;
        for(int i = 1 ; i <= N ; i++){
            if(!window[i])    count++;
        }
        System.out.println(count);
        br.close();
    }
    
    // Gemini 개선 풀이 - 완전 제곱수 찾기
    // 짝수번 창문을 건들이면 닫힌 상태
    // 홀수번 창문을 건들이면 열린 상태
    // => 완전제곱수(열린 상태) 개수를 구하면 됨
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.sqrt(N));
        br.close();
    }
}