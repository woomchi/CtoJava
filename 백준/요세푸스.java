package 백준;
import java.io.*;
import java.util.*;

public class 요세푸스 {
    // 기존 나의 풀이 개선
    // index를 이동거리 -1 의 나머지로 구함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0; // 현재 삭제할 위치를 가리키는 포인터

        while (list.size() > 1) {
            // 공식: (현재 위치 + 이동할 거리) % 남은 사람 수
            index = (index + M - 1) % list.size();
            
            sb.append(list.remove(index)).append(", ");
        }
        
        sb.append(list.remove(0)).append(">");
        System.out.println(sb);
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        Deque<Integer> que = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++)   que.offer(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(que.size() > 1){
            for(int i = 0 ; i < M-1 ; i++){
                que.offer(que.poll());
            }
            sb.append(que.poll()).append(", ");
        }
        sb.append(que.poll()).append(">");
        System.out.println(sb);
        br.close();
    }
}
