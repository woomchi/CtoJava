package 백준;
import java.io.*;
import java.util.*;

class test{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("1")){
                deq.addFirst(Integer.parseInt(st.nextToken()));
            }else if(cmd.equals("2")){
                deq.addLast(Integer.parseInt(st.nextToken()));
            }else if(cmd.equals("3")){
                if(!deq.isEmpty()){
                    sb.append(deq.poll()).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }else if(cmd.equals("4")){
                if(!deq.isEmpty()){
                    sb.append(deq.pollLast()).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }else if(cmd.equals("5")){
                sb.append(deq.size()).append("\n");
            }else if(cmd.equals("6")){
                if(!deq.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append("1\n");
                }
            }else if(cmd.equals("7")){
                if(!deq.isEmpty()){
                    sb.append(deq.peek()).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }else if(cmd.equals("8")){
                if(!deq.isEmpty()){
                    sb.append(deq.peekLast()).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이 - swtich문과 명시된 메서드명으로 리펙터링
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            switch(cmd) {
                case "1":
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "3":
                    sb.append(deq.isEmpty() ? -1 : deq.pollFirst()).append("\n");
                    break;
                case "4":
                    sb.append(deq.isEmpty() ? -1 : deq.pollLast()).append("\n");
                    break;
                case "5":
                    sb.append(deq.size()).append("\n");
                    break;
                case "6":
                    sb.append(deq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "7":
                    sb.append(deq.isEmpty() ? -1 : deq.peekFirst()).append("\n");
                    break;
                case "8":
                    sb.append(deq.isEmpty() ? -1 : deq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}