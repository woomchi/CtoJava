package 백준;
import java.io.*;
import java.util.*;

class N과M4{
    static int N, M;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0);
        System.out.print(sb);
        br.close();
    }
    
    public static void dfs(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 1 ; i <= N ; i++){
            if(depth > 0){
                if(arr[depth-1] <= i){
                    arr[depth] = i;
                    dfs(depth+1);
                }
            }else{
                arr[depth] = i;
                dfs(depth+1);
            }
        }
    }

    // 다른 사람 풀이(Gemini 풀이도 마찬가지)
    public static void solutionGemini(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs1(0, 1);
        System.out.print(sb);
        br.close();
    }
    public static void dfs1(int depth, int prev){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // 중복을 허용하되 비내림차순이므로 다음 시작 숫자는 i로 지정
        for(int i = prev ; i <= N ; i++){
            arr[depth] = i;
            dfs1(depth+1, i);
        }
    }
}