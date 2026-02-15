package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class queuestack {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Long> list = new ArrayDeque<>();
        int [] state = new int[N];
        for(int i = 0 ; i < N ; i++){
            state[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(st.nextToken());
            if(state[i] == 0){
                list.offer(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            long num = Long.parseLong(st.nextToken());
            list.addFirst(num);
            sb.append(list.pollLast()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    // Gemini 개선 풀이 - 리펙 터링
    // 객체명 변경
    // 예외처리에 안전한 offerFirst로 변경
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Long> dq = new ArrayDeque<>();
        int [] state = new int[N];
        for(int i = 0 ; i < N ; i++){
            state[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(st.nextToken());
            if(state[i] == 0){
                dq.offer(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            long num = Long.parseLong(st.nextToken());
            dq.offerFirst(num);
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
