package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳찾기 {
    // 나의 풀이
    // 굳이 count 변수를 사용하지 않고 바로 append하는 방식이 더 좋음
    // int 말고 char의 ++ 연산으로 반복문을 사용하는게 가독성 측면에서 더 좋음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 97; i <= 122; i++){
            int count = 0;
            for(int j = 0; j < str.length(); j++){
                if(i == str.charAt(j)){
                    break;
                }
                count++;
            }
            if(count==str.length()){
                sb.append(-1).append(" ");
            }else{
                sb.append(count).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) { // 97~122 대신 'a'~'z' 사용 (가독성)
            boolean isFound = false;
            
            for (int j = 0; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    sb.append(j).append(" "); // 찾았으면 현재 인덱스(j) append
                    isFound = true;
                    break; // 찾았으니 탈출
                }
            }
            
            if (!isFound) {
                sb.append(-1).append(" "); // 끝까지 못 찾았으면 -1
            }
        }
        System.out.println(sb.toString().trim());
    }
}
