package 백준;
import java.util.*;
import java.io.*;

class 스택2{
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        List<Integer> stack = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            char ch = str.charAt(0);
            if(ch == '1'){
                stack.add(Integer.parseInt(str.substring(2)));                
            }else if(ch == '2'){
                if(!stack.isEmpty()){
                    sb.append(stack.remove(stack.size()-1));
                }else{
                    sb.append(-1);
                }
                sb.append("\n");
            }else if(ch == '3'){
                sb.append(stack.size()).append("\n");
            }else if(ch == '4'){
                if(stack.isEmpty()){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            }else if(ch == '5'){
                if(!stack.isEmpty()){
                    sb.append(stack.get(stack.size()-1));
                }else{
                    sb.append(-1);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이 - int 배열 활용(박싱 오버헤드 제거)
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        // ArrayList 대신 고정 배열 사용 (최대 명령 수 N만큼 크기 할당)
        // 오토박싱 없이 int형을 그대로 사용하여 메모리와 속도 최적화
        int[] stack = new int[N]; 
        int top = 0; // 스택의 현재 크기이자, 다음 데이터가 들어갈 인덱스

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "1":
                    // StringTokenizer로 다음 토큰(정수)을 안전하게 가져옴
                    stack[top++] = Integer.parseInt(st.nextToken());
                    break;
                case "2":
                    if(top > 0) {
                        sb.append(stack[--top]).append("\n"); // top을 먼저 줄이고 값 가져옴
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "3":
                    sb.append(top).append("\n");
                    break;
                case "4":
                    if(top == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "5":
                    if(top > 0) {
                        sb.append(stack[top - 1]).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}