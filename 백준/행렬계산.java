package 백준;

import java.io.*;
import java.util.*;

public class 행렬계산 {
    // 나의 풀이
    // 원초적인 방법으로 잘 품 => But, StringTokenizer를 사용하면 더 좋음
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        
        int[][] arr = new int[n1][n2];
        for(int i=0;i<2;i++){
            for(int j=0;j<n1;j++){
                for(int k=0;k<n2;k++){
                    arr[j][k] += sc.nextInt();
                }
            }
        }
        sc.close();
        for(int[] i: arr){
            for(int j=0;j<n2;j++){
                System.out.print(i[j]+" ");
            }
            System.out.print("\n");
        }
    }

    // Gemini의 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        
        // 2개의 행렬을 처리
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                // 매 행마다 새로운 토큰 생성 (한 줄을 읽어서 공백으로 자름)
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[j][k] += Integer.parseInt(st.nextToken());
                }
            }
        }
        
        // 빠른 출력을 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
