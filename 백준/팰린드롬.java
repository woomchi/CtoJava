package 백준;
import java.io.*;

class 팰린드롬{
    // 나의 풀이
    // 로직 자체는 좋지만, 투포인터 방식은 문자열의 길이만큼 확인하면 중복 연산이 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(팰린드롬.palindrome1(str));
        br.close();
    }
    private static int palindrome1(String str){
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return 0;
            }
        }
        return 1;
    }

    // Gemini 개선 풀이
    // 문자열의 절반 길이만큼 연산하면 중복없이 최적으로 팰린드롬인지 확인할 수 있음
    // 어차피 클래스 안의 main 함수이므로 Main.을 명시할 필요없음
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        System.out.println(palindrome2(str));
        
        br.close();
    }

    private static int palindrome2(String str) {
        int len = str.length();
        // 최적화: 문자열의 절반까지만 반복
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return 0; // 대칭이 아니면 즉시 0 반환
            }
        }
        return 1; // 끝까지 통과하면 팰린드롬
    }
}