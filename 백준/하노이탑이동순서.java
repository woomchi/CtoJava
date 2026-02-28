package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서 {
    // Gemini의 도움을 받아 풀이
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 하노이탑 이동 횟수는 정해져있음
        sb.append((int)Math.pow(2,N)-1).append("\n");
        dfs(N, 1, 2, 3);
        System.out.print(sb);
        br.close();
    }

    public static void dfs(int n, int start, int mid, int end){
        // 원반이 1개일 때 한 번만 옮기면 되므로 바로 출력
        // 아니면 나머지(n-1)를 이동시키고 출력
        if(n == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        // mid는 가장 큰 원반을 옮기기 위해 나머지 원반이 임시로 존재하는 막대
        dfs(n-1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        dfs(n-1, mid, start, end);
    }
}
