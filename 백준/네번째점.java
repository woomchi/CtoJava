package 백준;
import java.io.*;
import java.util.*;

public class 네번째점 {
    // 나의 풀이
    public static void main(String[] args) throws IOException{
        final int input_len = 3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1 = 0; int y1 = 0;
        int x2 = 0; int y2 = 0;
        int[][] arr = new int[3][2];
        for(int i = 0 ; i < input_len ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x1 == 0){
                x1 = x;
            }else if(x1 !=0 && x1 != x){
                x2 = x;
            }
            
            if(y1 == 0){
                y1 = y;
            }else if(y1 != 0 && y1 != y){
                y2 = y;
            }
            arr[i][0] = x;
            arr[i][1] = y;
        }

        int countX1 = 0;   int countY1 = 0;
        int countX2 = 0;    int countY2 = 0;
        for(int i = 0 ; i < input_len ; i++){
            int x = arr[i][0];
            int y = arr[i][1];
            if(x == x1){
                countX1++;
            }else if(x == x2){
                countX2++;
            }
            
            if(y == y1){
                countY1++;
            }else if(y == y2){
                countY2++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(countX1 == 1){
            sb.append(x1).append(" ");
        }else if(countX2 == 1){
            sb.append(x2).append(" ");
        }
        if(countY1 == 1){
            sb.append(y1);
        }else if(countY2 == 1){
            sb.append(y2);
        }
        System.out.println(sb);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = 0;
        int y = 0;
        
        // 3번 반복하면서 XOR 연산 누적
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inputX = Integer.parseInt(st.nextToken());
            int inputY = Integer.parseInt(st.nextToken());
            
            // XOR 연산: 같은 값이 두 번 들어오면 0이 되어 사라지고,
            // 한 번만 등장한 값만 변수에 남게 됩니다.
            x = x ^ inputX;
            y = y ^ inputY;
        }
        
        System.out.println(x + " " + y);
        br.close();
    }
}
