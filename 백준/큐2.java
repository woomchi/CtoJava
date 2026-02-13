package 백준;

import java.io.*;
import java.util.*;

class 큐2{
    // 나의 풀이
    // Queue 대신 ArrayDeque 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }else if(cmd.equals("empty")){
                if(stack.isEmpty()){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }else if(cmd.equals("size")){
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
            }else if(!stack.isEmpty()){
                if(cmd.equals("back")){
                    bw.write(String.valueOf(stack.peek()));
                }else if(cmd.equals("pop")){
                    bw.write(String.valueOf(stack.pollLast()));
                }else if(cmd.equals("front")){
                    bw.write(String.valueOf(stack.peekLast()));
                }
                bw.newLine();
            }else if(stack.isEmpty()){
                bw.write("-1\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    
    // Gemini 개선 풀이 - 각 명령어에 대한 예외처리
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            if (cmd.equals("push")) {
                int val = Integer.parseInt(st.nextToken());
                queue.offer(val); // 큐의 뒤에 삽입
            } 
            else if (cmd.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.poll() + "\n"); // 앞의 값 제거 및 출력
                }
            } 
            else if (cmd.equals("size")) {
                bw.write(queue.size() + "\n");
            } 
            else if (cmd.equals("empty")) {
                bw.write((queue.isEmpty() ? 1 : 0) + "\n");
            } 
            else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.peek() + "\n"); // 맨 앞 값 확인
                }
            } 
            else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.peekLast() + "\n"); // 맨 뒤 값 확인
                }
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
