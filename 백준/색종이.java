package 백준;
import java.io.*;
import java.util.*;

class 색종이{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] bound = new boolean[101][101];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = x ; j < x + 10 ; j++){
                for(int k = y ; k < y + 10 ; k++){
                    bound[j][k] = true;
                }
            }
        }

        int area = 0;
        for(int i = 0 ; i < 101; i++){
            for(int j = 0 ; j < 101 ; j++){
                if(bound[i][j]) area++;
            }
        }
        System.out.println(area);
        br.close();
    }
}