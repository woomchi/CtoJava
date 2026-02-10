package 백준;
import java.io.*;
import java.util.*;

class 균형잡힌세상{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while(!(str = br.readLine()).equals(".")){
            Deque<Character> stack = new ArrayDeque<>();
            for(int j = 0 ; j < str.length() ; j++){
                char ch = str.charAt(j);
                if(ch != '(' && ch != ')' && ch != '[' && ch != ']')    continue;
                if(stack.isEmpty()){
                    stack.push(ch);
                    if(ch == ')' || ch == ']'){
                        break;
                    }
                }else{
                    if(ch == '(' || ch == '['){
                        stack.push(ch);
                    }else if(ch == ')'){
                        if(stack.peek() == '('){
                            stack.pop();
                        }else{
                            break;
                        }
                    }else if(ch == ']'){
                        if(stack.peek() == '['){
                            stack.pop();
                        }else{
                            break;
                        }
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("yes\n");
            }else{
                sb.append("no\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        // 1. null 체크 추가로 안정성 확보
        while ((str = br.readLine()) != null && !str.equals(".")) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true; // 균형 여부를 판단하는 플래그

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                // 여는 괄호: 무조건 push
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } 
                // 닫는 괄호: 스택 확인
                else if (ch == ')') {
                    // 스택이 비어있거나 짝이 안 맞으면 실패
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            // 2. 스택에 잔여물이 있거나, 도중에 실패 플래그가 떴다면 "no"
            if (isValid && stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}