package 백준;
import java.util.*;

public class 문자열 {
    // 나의 문제 풀이
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i=0;i<count;i++){
            String word = sc.next();
            String firstWord = String.valueOf(word.charAt(0));
            String lastWord = String.valueOf(word.charAt(word.length()-1));
            System.out.println(firstWord+lastWord);
        }
        sc.close();
    }

    public void solution(){
        // Gemini의 개선 풀이
        // 입력받은 문자열을 가변적인 문자 배열인 StringBuilder에 저장함으로써
        // 모든 데이터에 대하여 문자열로 append할 수 있음   
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        
        StringBuilder sb = new StringBuilder(); // 결과값을 모으기 위한 도구

        for (int i = 0; i < count; i++) {
            String word = sc.next();
            // 첫 글자와 마지막 글자를 StringBuilder에 추가
            sb.append(word.charAt(0))
              .append(word.charAt(word.length() - 1))
              .append("\n"); // 줄바꿈 추가
        }
        
        System.out.print(sb); // 한 번에 출력
        sc.close();
    }
}
