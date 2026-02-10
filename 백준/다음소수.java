package 백준;
import java.io.*;
import java.math.BigInteger;

class 다음소수{
    // Gemini의 피드백 참고 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine().trim());
        
        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(br.readLine());

            if(num <=2){
                bw.write("2\n");
                continue;
            }

            if (num % 2 == 0) {
                num++;
            }
            
            while(true) {
                if(isPrime(num)) {
                    bw.write(num+"\n");
                    break;
                }
                num += 2;
            }
        }        
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isPrime(long n){
        if(n < 2)   return false;
        if(n == 2)  return true;
        for(long i = 2; i * i <= n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    // Gemini 개선 풀이 - BigInteger 메서드 활용
    // 다만, 메모리 및 효율성 측면에서 떨어짐
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 테스트 케이스 개수
        long T = Long.parseLong(br.readLine());
        
        for(int i = 0; i < T; i++) {
            // BigInteger로 입력 받기
            BigInteger n = new BigInteger(br.readLine());
            
            // 만약 n이 이미 소수라면 n을 출력
            if (n.isProbablePrime(10)) {
                bw.write(n.toString());
            } else {
                // 아니라면 n보다 큰 다음 소수를 찾아서 출력
                bw.write(n.nextProbablePrime().toString());
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}