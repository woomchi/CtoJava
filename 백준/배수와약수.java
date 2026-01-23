package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 배수와약수 {
    // 나의 풀이
    // 약수 조건이 잘못됨
    // neither 조건이 잘못됨
    // 반복문 탈출 조건이 불가능함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            if(br==null)    break;
            boolean isFactor = false;
            boolean isMultiple = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(first == second)    break;
            if(second/first!=0){
                isFactor = true;
            }
            if(first/second>0 && first%second==0){
                isMultiple = true;
            }

            if(isFactor == true){
                System.out.print("factor\n");
            }else if(isMultiple == true){
                System.out.print("multiple\n");
            }else if(isMultiple==false && isFactor==false && first > second){
                System.out.print("neither\n");
            }
        }
    }

    //Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력을 모아서 한 번에 하기 위함

        while (true) {
            String line = br.readLine();
            if (line == null) break; // 파일의 끝(EOF) 처리

            StringTokenizer st = new StringTokenizer(line);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            // 1. 종료 조건: 둘 다 0일 때
            if (first == 0 && second == 0) break;

            // 2. 판별 로직 (나머지 연산자 % 사용)
            if (second % first == 0) {
                sb.append("factor\n");
            } else if (first % second == 0) {
                sb.append("multiple\n");
            } else {
                sb.append("neither\n");
            }
        }
        System.out.print(sb);
    }
}
