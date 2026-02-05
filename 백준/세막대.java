package 백준;
import java.io.*;
import java.util.*;

class 세막대 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int [] side = { a, b, c };
        Arrays.sort(side);
        while(side[2] >= side[0] + side[1]){
            side[2]--;
        }
        System.out.println(side[0] + side[1] + side[2]);
        br.close();
    }

    // Gemini 개선풀이
    public static void soltuionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력을 배열로 받아 바로 처리
        int[] side = new int[3];
        side[0] = Integer.parseInt(st.nextToken());
        side[1] = Integer.parseInt(st.nextToken());
        side[2] = Integer.parseInt(st.nextToken());
        
        // 정렬: 오름차순 (side[0] <= side[1] <= side[2])
        Arrays.sort(side);
        
        // 핵심 로직: 반복문 제거 -> O(1) 수식 적용
        // 가장 긴 변이 나머지 두 변의 합보다 크거나 같다면
        // 삼각형을 만들 수 있는 최대 길이는 (나머지 두 변의 합 - 1)
        if (side[2] >= side[0] + side[1]) {
            side[2] = side[0] + side[1] - 1;
        }
        
        System.out.println(side[0] + side[1] + side[2]);
        br.close();
    }
}