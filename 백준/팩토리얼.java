package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(factorial(N));
    }
    
    public static int factorial(int n){
        if(n > 0)   return n * factorial(n-1);
        return 1;
    }

    // Gemini 개선 풀이
    // 범위를 고려하여 long형으로 반환
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력값이 작더라도 결과값은 long 범위일 수 있으므로 주의
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(factorial(N));
    }
    
    // 반환형을 long으로 변경
    public static long factorial1(int n){
        if(n <= 1) return 1; // 0! = 1, 1! = 1 처리
        return n * factorial(n-1);
    }
}
