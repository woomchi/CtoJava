package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 도키도키간식드리미 {
    // 나의 풀이
    // 가독성 측면에서 변수명 개선 필요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        for(int i = 1 ; i <= N ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(index != num){
                if(!stack.isEmpty()){
                    if(stack.peek() < num)    break;
                }
                stack.push(num);
            }else{
                index++;
            }
            while(!stack.isEmpty() && stack.peek() == index){
                stack.pop();
                index++;
            }
        }
        if(stack.isEmpty()){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }
        br.close();
    }

    // Gemini 개선 풀이
    // 조기 종료 활용
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int expected = 1; // 현재 간식을 받아야 하는 번호
        
        for(int i = 0 ; i < N ; i++){
            int currentStudent = Integer.parseInt(st.nextToken());
            
            // 1. 현재 순서의 학생인 경우 -> 바로 보냄
            if (currentStudent == expected) {
                expected++;
            } 
            // 2. 순서가 아니라면 스택에 넣어야 함
            else {
                // 스택에 넣기 전, 스택 맨 위의 학생이 현재 학생보다 작으면
                // 작은 학생이 갇히게 되므로 불가능한 경우 (Sad)
                if (!stack.isEmpty() && stack.peek() < currentStudent) {
                    System.out.println("Sad");
                    return; // 바로 프로그램 종료 (break 대신 return 사용)
                }
                stack.push(currentStudent);
            }
            
            // 3. 스택에서 보낼 수 있는 학생들을 연속해서 보냄
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }
        
        // 모든 과정 후 스택이 비어있으면 성공, 아니면 실패
        // 위에서 실패 시 return했으므로 여기 도달하고 스택이 비어있다면 Nice
        // 하지만 논리적 완결성을 위해 isEmpty 체크
        System.out.println("Nice");
        br.close();
    }
}
