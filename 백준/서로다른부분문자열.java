package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        
        HashSet<String> set = new HashSet<>((len*(len+1)/2));
        for(int i = 1 ; i <= len ; i++){
            for(int j = 0 ; j < len+1-i ; j++){
                String subStr = str.substring(j,j+i);
                set.add(subStr);
            }
        }
        System.out.println(set.size());
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        // HashSet 사용 (초기 용량 생략해도 N=1000 수준에선 무방하나, 넣는다면 아래처럼)
        Set<String> set = new HashSet<>();

        // i: 시작 인덱스, j: 끝 인덱스 (이 방식이 더 직관적인 경우가 많습니다)
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                // substring(start, end) -> end 인덱스는 포함되지 않음
                set.add(str.substring(i, j));
            }
        }

        System.out.println(set.size());
        br.close();
    }
}
