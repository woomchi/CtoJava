package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M1 {
    // 다른 사람 풀이 참조 및 분석 - 백트레킹의 기초
    // 각 경우의 수에 대한 '숫자 구성'과 '방문 여부', 즉 상태 추적을 위해 전역 변수 사용
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    
    // 특정 깊이(자리수)에서 1~N까지 숫자 경우의 수를 확인할 때 앞의 자리수에서 사용되었는지 확인
    static boolean [] visit;
    static int [] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        
        // 전역 변수 초기화
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visit = new boolean[N+1];
        arr = new int[M];
        
        // 깊이 0부터 순차적으로 탐색 시작
        dfs(0);
        System.out.println(sb);
        br.close();
    }
    
    public static void dfs(int depth){
        // 깊이가 M이면 저장된 배열의 숫자 구성 출력
        // 이전에 저장된 상태들이 출력되고 이전 경우의 수로 돌아가서 다른 숫자 조합의 가능성 확인
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // 특정 깊이에서 모든 숫자 구성(1~N)을 확인함
        for(int i = 1 ; i <= N ; i++){
            // 방문하지 않았다면 방문 처리 후 배열에 저장
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i;    // element : 1~N
                
                // 현재 상태에서 다음 자리수(depth)의 경우 확인 
                dfs(depth+1);
                // 현재 상태에서 다음 상태가 확인되어 return;하면, 방문 상태 초기화
                visit[i] = false;
            }
        }
    }
}
