package 백준;
import java.io.*;

class 영화감독숌{
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 666이 포함된 수를 발견하면 count
        int num = 666;
        int count = 0;
        while(true){
            if(String.valueOf(num).contains("666")){
                System.out.println(num);
                count++;
            }
            if(count == N)    break;
            num++;
        }
        System.out.println(num);
        br.close();
    }

    // Gemini 개선 풀이 - 수학적 연산
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 666이 포함된 수를 발견하면 count
        int num = 666;
        int count = 1;
        while(count != N){
            num++;
            if(has666(num)){
                count++;
            }
        }
        System.out.println(num);
        br.close();
    }

    public static boolean has666(int num) {
        while (num >= 666) {
            if (num % 1000 == 666) { // 끝 3자리가 666인지 확인
                return true;
            }
            num /= 10; // 끝자리 하나 제거
        }
        return false;
    }
}