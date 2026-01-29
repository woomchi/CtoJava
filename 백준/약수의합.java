package 백준;
import java.io.*;
import java.util.*;

public class 약수의합 {
    // 나의 풀이
    // String 타입으로 저장하기 위해 i을 boxing하는 것은 비효율적
    // queue를 사용하면 직관적이지 못함
    // 반복문은 입력값이 -1일 때를 처음 예외 처리로 탈출 시키는 것이 가독성이 좋음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(input!=-1){
            int sum = 0;
            Queue<String> q = new LinkedList<>();
            for(int i = 1; i < input; i++){
                if(input%i==0){
                    sum += i;
                    q.add(String.valueOf(i));    
                }
            }
            if(sum == input){
                sb.append(input).append(" = ");
                String temp = q.poll();
                while(!q.isEmpty()){
                    sb.append(temp).append(" + ");
                    temp = q.poll();
                }
                sb.append(temp).append("\n");
            }else{
                sb.append(input).append(" is NOT perfect.\n");
            }
            
            input = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            
            // 입력 종료 조건
            if (n == -1) break;

            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;

            // 1. 최적화: n/2 까지만 반복해도 모든 약수를 찾을 수 있음
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                // 완전수일 경우 출력 포맷 생성
                sb.append(n).append(" = ");
                
                // 첫 번째 약수는 그냥 추가
                sb.append(list.get(0));
                
                // 두 번째 약수부터는 " + 약수" 형태로 추가
                for (int i = 1; i < list.size(); i++) {
                    sb.append(" + ").append(list.get(i));
                }
                sb.append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }
        
        System.out.print(sb);
        br.close();
    }
}
