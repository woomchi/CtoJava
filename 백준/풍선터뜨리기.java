package 백준;
import java.io.*;
import java.util.*;

class 풍선터뜨리기{
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<int []> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            int [] temp = { Integer.parseInt(st.nextToken()), i };
            dq.offer(temp);
        }
        
        StringBuilder sb = new StringBuilder();
        int[] element = dq.pollFirst();
        int val = element[0];
        sb.append(element[1]).append(" ");
        for(int i = 1 ; i < N ; i++){
            if(val > 0){
                for(int j = 1 ; j < val ; j++){
                    dq.offerLast(dq.pollFirst());
                }
                element = dq.pollFirst();
                val = element[0];
            }else{
                for(int j = 1 ; j < Math.abs(val) ; j++){
                    dq.offerFirst(dq.pollLast());
                }
                element = dq.pollLast();
                val = element[0];
            }
            sb.append(element[1]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    // Gemini 개선 풀이 - 회전 부분 개선
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<int []> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            int [] temp = { Integer.parseInt(st.nextToken()), i };
            dq.offer(temp);
        }
        
        StringBuilder sb = new StringBuilder();
        int[] element = dq.pollFirst();
        int val = element[0];
        sb.append(element[1]).append(" ");
        for(int i = 1 ; i < N ; i++) {
            // 1. 덱 회전 (이동)
            if (val > 0) {
                for (int j = 1; j < val; j++) dq.offerLast(dq.pollFirst());
                element = dq.pollFirst();
            } else {
                for (int j = 1; j < Math.abs(val); j++) dq.offerFirst(dq.pollLast());
                element = dq.pollLast();
            }
            
            // 2. 값 갱신 및 출력 (공통 처리)
            val = element[0];
            sb.append(element[1]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}