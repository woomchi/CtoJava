package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {
    // 나의 풀이
    // 굳이 ' '을 채우지 않고 char 배열의 기본값을 확인하여 걸러내는 방법이 있음
    public static void main(String[] args) throws IOException {
        final int len = 5;
        final int maxlength = 15;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[len][maxlength];
        for(int i = 0 ; i < len;  i++){
            String str = br.readLine();
            for(int j = 0 ; j < maxlength ; j++){
                if(j >= str.length()){
                    arr[i][j] = ' ';
                }else{
                    arr[i][j] = str.charAt(j);
                }
                
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < maxlength; j++){
            for(int i = 0; i < len; i++){
                if(arr[i][j] == ' '){
                    sb.append("");
                }else{
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
    
    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 문자열 그대로 저장 (2차원 char 배열 불필요)
        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 2. 세로로 읽기
        // 최대 길이는 15라고 문제에 명시됨
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                // 해당 줄의 길이가 현재 읽으려는 인덱스(j)보다 길 때만 읽음
                if (j < lines[i].length()) {
                    sb.append(lines[i].charAt(j));
                }
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}
