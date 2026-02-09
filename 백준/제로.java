package 백준;
import java.io.*;
import java.util.*;

class 제로{
    // 나의 풀이
    // poll 사용으로 인한 nullpointerexception 발생 가능
    // 직관적으로 스택 구조임을 알지 못할 수 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Long> stack = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(br.readLine());
            if(num != 0){
                stack.add(num);
            }else{
                stack.pollLast();
            }
        }
        
        long sum = 0;
        for(long l : stack){
            sum += l;
        }
        System.out.println(sum);
        br.close();
    }

    // Gemini 개선 풀이
    // 기존 stack에서 쓰이는 삽입 제거인 push, pop을 사용하여 의도 명확히 전달
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N이 크지 않다면 int로 충분합니다.
        int N = Integer.parseInt(br.readLine());
        
        // 스택으로 사용할 때는 push/pop 메서드가 직관적입니다.
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.push(num); 
            } else {
                // 비어있는 경우를 대비해 isEmpty() 체크를 넣어주면 더 안전합니다.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        
        long sum = 0;
        // 향상된 for문으로 스택의 모든 요소를 합산
        for (int value : stack) {
            sum += value;
        }
        
        System.out.println(sum);
        br.close();
    }
}