package 백준;

import java.io.*;

public class 코딩은체육과목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N/4; i++){
            sb.append("long ");
        }
        sb.append("int\n");
        System.out.println(sb.toString());
    }

    // Gemini 개선 풀이1
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N/4; i++){
            sb.append("long ");
        }
        // 어차피 \n로 줄바꿈을 추가했기 때문에 print 메서드를 사용하면 됨
        sb.append("int\n");
        System.out.print(sb.toString());
    }

    //Gemini 개선 풀이2 - String.repeat 메서드 활용
    public static void soltuionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("long ".repeat(N/4) + "int\n");
    }
}
