package 백준;
import java.io.*;
import java.util.*;

class 최소공배수{
    // 나의 풀이
    // 시간복잡도가 매우 크므로 유클리드 호제법으로 개선해야 함
    // 값 계산 중에 int 범위를 벗어날 수 있으니 long으로 다루는게 좋음
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int lcm = 1;
            for(int j = 2; j <= Math.min(A,B) ; j++){
                while(true){
                    if(A%j != 0 || B%j != 0 )   break;
                    A /= j;
                    B /= j;
                    lcm *= j;
                }
            }
            lcm *= A * B;
            sb.append(lcm).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이 - 유클리드 호제법
    // 유클리드 호제법으로 최대공약수를 구함
    // 두 수의 곱을 최대공약수로 나눔
    // => 최소공배수 = 두 수의 곱 / 최대공약수
    public static void solution유클리드호제법(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            
            // LCM = (A * B) / GCD
            // A * B가 int 범위를 넘을 수 있으므로 long으로 형변환하여 계산 권장
            // 문제 조건에 따라 int로 충분하다면 int 사용 가능
            long result = (A * B) / getGCD(A, B);
            
            sb.append(result).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    // 최대공약수(GCD)를 구하는 유클리드 호제법 함수
    // 반복문 방식 (재귀보다 오버헤드가 적음)
    public static long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}