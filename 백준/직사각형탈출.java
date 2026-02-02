package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 직사각형탈출{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int minValue = Math.min(x, Math.min(y, Math.min(w-x, h-y)));
        // int minX = Math.min(x, w - x); // 가로 방향 중 짧은 거리 (왼쪽 vs 오른쪽)
        // int minY = Math.min(y, h - y); // 세로 방향 중 짧은 거리 (아래 vs 위)
        // int result = Math.min(minX, minY); // 둘 중 더 짧은 것 선택
        System.out.println(minValue);
        br.close();
    }
}
