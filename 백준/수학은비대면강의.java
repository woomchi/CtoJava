package 백준;
import java.io.*;
import java.util.*;

class 수학은비대면강의{
    /* 핵심 로직 : 모든 경우의 수 대입 / 가감법 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x1 = 0;    int y1 = 0;    int c1 = 0;
        int x2 = 0;    int y2 = 0;    int c2 = 0;
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        
        int xVal = 0;
        int yVal = 0;
        for(int i = -999 ; i <=999 ; i++){
            for(int j = -999 ; j <= 999 ; j++){
                if(x1*i + y1*j == c1 && x2*i + y2*j == c2){
                    xVal = i;
                    yVal = j;
                    break;
                }
            }
        }
        
        System.out.println(xVal + " " + yVal);
        br.close();
    }

    // Gemini 개선 풀이 - 가감법
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 문제의 수식 계수대로 변수명 매칭 (ax + by = c, dx + ey = f)
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        // 유일한 해가 존재하므로 분모(ae - bd)는 0이 아님
        // 공식을 이용한 O(1) 풀이
        int x = (c * e - b * f) / (a * e - b * d);
        int y = (a * f - c * d) / (a * e - b * d);
        
        System.out.println(x + " " + y);
        br.close();
    }
}