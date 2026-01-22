package 백준;
import java.util.*;
import java.io.*;

public class 체스기물 {
    // 나의 문제 풀이
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 킹 & 퀸 확인
        for(int i=0;i<2;i++){
            int object = sc.nextInt();
            System.out.print((1-object)+" ");
        }
        // 비숍 & 나이트 & 룩 확인
        for(int i=0;i<3;i++){
            int object = sc.nextInt();
            System.out.print((2-object)+" ");
        }
        // 폰 확인
        int object = sc.nextInt();
        System.out.print((8-object)+" ");
        sc.close();
    }

    public void solution() throws IOException {
        // 1. BufferedReader를 사용하여 속도 향상 => 이 부분은 알고리즘 문제에서 더 효율적인 입력을 돕기 때문에 암기하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 2. 결과값을 모아서 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 3. 체스 기물의 기준 개수를 배열로 정의 (킹, 퀸, 룩, 비숍, 나이트, 폰)
        int[] required = {1, 1, 2, 2, 2, 8};
        
        for (int i = 0; i < 6; i++) {
            int current = Integer.parseInt(st.nextToken());
            // 기준 개수에서 현재 개수를 뺀 값을 StringBuilder에 추가
            sb.append(required[i] - current).append(" ");
        }
        
        // 4. 최종 결과 출력
        System.out.println(sb.toString().trim());
    }
}
