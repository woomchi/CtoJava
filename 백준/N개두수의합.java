package 백준;

import java.io.*;
import java.util.*;

public class N개두수의합 {
    // 나의 풀이
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            StringTokenizer element = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(element.nextToken());
            int B = Integer.parseInt(element.nextToken());
            sb.append((A+B)+"\n");
        }
        System.out.print(sb.toString());
    }

    // Gemini 피드백 반영
    public static void solutionGemini(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A+B).append("\n");
        }
        System.out.print(sb.toString());
    }
}
