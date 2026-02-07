package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;
        
        int remain = N;
        int fiveKilo = remain/5;
        int threeKilo = 0;
        if(remain%5 != 0){
            for(int i = fiveKilo ; i >=0 ; i--){
                remain -= 5 * i;
                threeKilo = remain/3;
                if(remain%3 == 0){
                    result = i + threeKilo;
                    remain -= 3 * threeKilo;
                    break;
                }    
                remain = N;
            }
            if(remain != 0){
                result = -1;
            }
        }else{
            result = fiveKilo;
        }
        System.out.println(result);
        br.close();
    }

    // Gemini 개선 풀이 - 기존 코드 개선
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 5kg 봉지를 최대한 많이 쓸 수 있는 개수부터 0개까지 줄여나감
        int maxFive = N / 5;
        int result = -1;

        for (int i = maxFive; i >= 0; i--) {
            int remain = N - (5 * i); // 5kg을 i개 쓰고 남은 무게
            
            // 남은 무게가 3으로 나누어 떨어지면 정답
            if (remain % 3 == 0) {
                result = i + (remain / 3);
                break; // 최소 개수를 찾았으므로 즉시 종료 (Greedy)
            }
        }

        System.out.println(result);
        br.close();
    }

    // Gemini 개선 풀이 - 수학적 접근
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        while (N >= 0) {
            if (N % 5 == 0) { // 5로 나누어 떨어지면 5kg 봉지로만 다 채움
                count += N / 5;
                System.out.println(count);
                return;
            }
            N -= 3; // 5로 안 되면 3kg 봉지 하나 추가
            count++;
        }
        
        // N이 음수가 될 때까지 해결 못하면 불가능
        System.out.println(-1); 
    }
}
