package 백준;
import java.io.*;
import java.util.*;

class N과M2{
    // 나의 풀이
    // HashSet과 String 객체, 새로운 배열 생성으로 인한 메모리 사용률이 높음
    // 어차피 visit를 확인하며 방문 여부를 확인할 필요없음
    static int N, M;
    static int [] arr;
    // static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        // visit = new boolean[N+1];
        set = new HashSet<>();
        
        dfs(0);
        System.out.print(sb);
        br.close();
    }
    
    // public static void dfs(int depth){
    //     if(depth == M){
    //         int [] temp = new int[M];
    //         for(int i = 0 ; i < M ; i++){
    //             temp[i] = arr[i];
    //         }
    //         Arrays.sort(temp);
    //         if(set.add(Arrays.toString(temp))){
    //             for(int val: temp){
    //                 sb.append(val).append(" ");
    //             }
    //             sb.append("\n");
    //         }
    //         return;
    //     }
    //     for(int i = 1 ; i <= N ; i++){
    //         if(!visit[i]){
    //             arr[depth] = i;
    //             visit[i] = true;
    //             dfs(depth+1);
    //             visit[i] = false;
    //         }
    //     }
    // }

    // 나의 리펙터링
    public static void solutionRefactoring(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        set = new HashSet<>();
        
        dfs(0);
        System.out.print(sb);
        br.close();
    }
    
    public static void dfs(int depth){
        if(depth == M){
            for(int val: arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= N ; i++){
            if(depth > 0){
                if(arr[depth-1] < i){
                    arr[depth] = i;
                    dfs(depth+1);
                }
            }else{
                arr[depth] = i;
                dfs(depth+1);
            }
        }
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        arr = new int[M];
        
        // 탐색 시작: 깊이 0, 시작 숫자 1
        dfs1(0, 1);
        
        System.out.print(sb);
        br.close();
    }
    
    // start: 반복문이 시작될 숫자 (오름차순 유지를 위함)
    public static void dfs1(int depth, int start) {
        // M개를 모두 고른 경우 (Base Case)
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // i는 항상 start부터 시작하므로 오름차순이 보장됨
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            // 다음 깊이로 갈 때, 현재 고른 숫자(i)보다 1 큰 수부터 고르도록 넘김
            dfs1(depth + 1, i + 1);
        }
    }
}