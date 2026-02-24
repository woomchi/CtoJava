package 백준;
import java.io.*;
import java.util.StringTokenizer;

class N과M3{
    // 나의 풀이
    static int N, M;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
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
            arr[depth] = i;
            dfs(depth+1);
        }
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        dfs1(0);
        System.out.print(sb);
        br.close();
    }
    
    public static void dfs1(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 1 ; i <= N ; i++){
            arr[depth] = i;
            dfs1(depth+1);
        }
    }
}