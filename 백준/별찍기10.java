package 백준;
import java.io.*;

class 별찍기10{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                map[i][j] = '*';
            }
        }
        changeStar(map, 0, N, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    public static void changeStar(char[][] map, int x1, int x2, int y1, int y2){
        if(x2 - x1 >= 3 && y2 - y1 >= 3){
            int lenX = (x2-x1)/3;
            int lenY = (y2-y1)/3;
            for(int i = x1+lenX ; i < x1+lenX*2 ; i++){
                for(int j = y1+lenY ; j < y1+lenY*2 ; j++){
                    map[i][j] = ' ';
                }
            }
            changeStar(map, x1,         x1+lenX,        y1, y1+lenY);
            changeStar(map, x1+lenX,    x1+lenX*2,      y1, y1+lenY);
            changeStar(map, x1+lenX*2,  x2,             y1, y1+lenY);
            
            changeStar(map, x1,         x1+lenX,        y1+lenY, y1+lenY*2);
            changeStar(map, x1+lenX*2,  x2,             y1+lenY, y1+lenY*2);

            changeStar(map, x1,         x1+lenX,        y1+lenY*2, y2);
            changeStar(map, x1+lenX,    x1+lenX*2,      y1+lenY*2, y2);
            changeStar(map, x1+lenX*2,  x2,             y1+lenY*2, y2);
        }
    }

    // 다른 사람 풀이
    static char[][] arr;

    public static void solutionOther(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        draw(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void draw(int x, int y, int size) {

        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 1 && j == 1) {
                    fillBlank(x + newSize, y + newSize, newSize);
                } else {
                    draw(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    static void fillBlank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = '*';
            }
        }
        
        // 시작 좌표(0, 0)와 크기(N)를 넘겨줍니다.
        changeStar(map, 0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void changeStar(char[][] map, int x, int y, int size) {
        // 더 이상 나눌 수 없는 크기(3 미만)가 되면 종료
        if (size < 3) return;

        int newSize = size / 3;

        // 가운데 영역을 공백으로 채움
        for (int i = x + newSize; i < x + newSize * 2; i++) {
            for (int j = y + newSize; j < y + newSize * 2; j++) {
                map[i][j] = ' ';
            }
        }

        // 9개의 구역 중 정중앙을 제외한 8개 구역에 대해 재귀 호출
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 정중앙 구역(i == 1 && j == 1)은 이미 공백 처리했으므로 스킵
                if (i == 1 && j == 1) continue; 
                changeStar(map, x + (i * newSize), y + (j * newSize), newSize);
            }
        }
    }

    // Gemini 개선 풀이 - 수학적 좌표 계산 방식
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 2차원 배열 없이 바로 좌표(i, j)를 탐색하며 StringBuilder에 써 내려갑니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star(i, j, sb);
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }

    static void star(int x, int y, StringBuilder sb) {
        // x와 y가 0이 될 때까지 3으로 나누며 검사합니다.
        while (x > 0 || y > 0) {
            // 현재 스케일에서 x와 y가 모두 가운데 구역(나머지가 1)에 위치한다면
            if (x % 3 == 1 && y % 3 == 1) {
                sb.append(' ');
                return; // 공백임이 확정되었으므로 종료
            }
            
            // 다음 스케일(더 큰 단위)을 검사하기 위해 3으로 나눔
            x /= 3;
            y /= 3;
        }
        
        // 모든 스케일을 검사했는데도 공백 조건에 걸리지 않았다면 별을 찍음
        sb.append('*');
    }

    // Gemini 개선 풀이의 개선 풀이 - 수학적 좌표 버전
    // 기존 StringBuilder 인스턴스를 매개변수로 전달하지 않고 boolean으로 판별함으로써 로직 분리가 가능
    public static void SolutionGemini1_1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // true면 공백, false면 별을 찍도록 분리
                if (isBlank(i, j)) {
                    sb.append(' ');
                } else {
                    sb.append('*');
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }

    // 좌표가 주어졌을 때 공백 자리인지 '판별'만 하는 함수
    static boolean isBlank(int x, int y) {
        while (x > 0 || y > 0) {
            // 현재 스케일에서 정중앙(나머지가 1)에 위치한다면 공백 확정
            if (x % 3 == 1 && y % 3 == 1) {
                return true; 
            }
            
            // 다음 스케일 검사를 위해 3으로 나눔 (스케일을 키움)
            x /= 3;
            y /= 3;
        }
        
        // 끝까지 통과했다면 별 자리임이 확정
        return false;
    }
}