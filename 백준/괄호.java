package 백준;
import java.io.*;
import java.util.*;

class 괄호{
    // 나의 풀이
    // 선입 선출 방식으로 잘못 짜임 => but 통과는 됨?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int k = 0 ; k < N ; k++){
            String isVPS = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0 ; i < isVPS.length() ; i++){
                char ch = isVPS.charAt(i);
                if(stack.isEmpty()){
                    if(ch == '('){
                        stack.add(ch);
                    }else if(ch == ')'){
                        stack.add(ch);
                        break;
                    }
                }else{
                    if(ch == '('){
                        stack.add(ch);
                    }else if(ch == ')'){
                        if(stack.peek() == '('){
                            stack.pop();
                        }
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < N; k++) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(') {
                    stack.push(ch); // add 대신 push 사용 (LIFO 보장)
                } else {
                    // 닫는 괄호가 왔는데 스택이 비어있으면 잘못된 괄호 문자열
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            // 스택이 비어있지 않거나, 중간에 실패했다면 NO
            if (!stack.isEmpty() || !isValid) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }

    // Gemini 제안 방식 - 컬렉션 클래스 없이 stack 구조 만들기
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            int count = 0;
            boolean isVPS = true;

            for(int j = 0 ; j < input.length() ; j++){
                char ch = input.charAt(j);
                if(ch == '('){
                    count++;
                }else if(ch == ')'){
                    count--;
                    if(count < 0){
                        isVPS = false;
                        break;
                    }
                }
            }
            if(isVPS && count == 0){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}