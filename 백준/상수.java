package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수 {
    // 나의 풀이
    // 굳이 String 객체를 생성할 필요없이 toString을 통한 메서드 체이닝을 사용하면 더 간결함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken());
        int n1 = Integer.parseInt(new String(sb.reverse()));
        
        sb = new StringBuilder();
        sb.append(st.nextToken());
        int n2 = Integer.parseInt(new String(sb.reverse()));
        
        System.out.println(Math.max(n1,n2));
    }

    // Gemini 개선풀이 - 세련된 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 변수 선언 없이 한 줄로 처리 (읽기 -> StringBuilder 생성 -> 뒤집기 -> 문자열변환 -> 정수변환)
        int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        
        System.out.println(Math.max(A, B));
    }
}
