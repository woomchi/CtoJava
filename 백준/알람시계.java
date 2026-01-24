package 백준;

import java.io.*;
import java.util.*;

public class 알람시계 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = 60 * Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = h + m - 45;
        if(min < 0){
            h = (1440+min)/60;
            m = (1440+min)%60;
        }else{
            h = min/60;
            m = min%60;
        }
        System.out.println(h+" "+m);
    }
    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 1. 전체를 분으로 환산하고 45분을 뺍니다.
    int totalMin = h * 60 + m - 45;

    // 2. 음수가 될 경우를 대비해 1440을 더해주고, 다시 1440으로 나눈 나머지를 구합니다.
    // 식: (계산된 분 + 하루의 분) % 하루의 분
    totalMin = (totalMin + 1440) % 1440; 

    // 3. 시와 분으로 다시 변환
    // if-else 없이 바로 계산 가능!
    System.out.println((totalMin / 60) + " " + (totalMin % 60));
}
}
