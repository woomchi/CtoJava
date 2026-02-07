package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소트인사이드 {
    // 나의 풀이
    // 계수 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        
        int [] count = new int[10];
        for(int i = 0 ; i < len ; i++){
            count[num.charAt(i)-'0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9 ; i >= 0 ; i--){
            for(int j = 0 ; j < count[i]; j++){
                sb.append(i);
            }
        }
        System.out.println(sb);
        br.close();
    }

    // Gemini가 말아주는 다른 일반적인 방식
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        
        char [] str = num.toCharArray();
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        for(int i = str.length-1; i >= 0 ; i--){
            sb.append(str[i]);
        }
        System.out.println(sb);
        br.close();
    }
}
