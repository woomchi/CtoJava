package 백준;
import java.io.*;
import java.util.*;

class 체스판다시칠하기{

    // 나의 풀이
    // int 하드 코딩으로 인한 실수 발생할 수 있음
    // String -> int 과정에서 연산 비용 발생
    // => 차라리 boolean으로 체크하는게 나음
    static final int board_n = 2;
    static final int board_w = 8;
    static final int board_h = 8;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 줄(렬)
        int M = Integer.parseInt(st.nextToken());    // 행
        
        int [][] board1 = {{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},
                           {1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1}};
        int [][] board2 = {{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},
                         {0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0}};
        
        // W 1 B 0
        int[][] map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            str = (str.replace("B","0")).replace("W","1");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        
        int minValue = Integer.MAX_VALUE;
        int mv1 = N - board_w;
        int mv2 = M - board_h;
        for(int n = 0 ; n <= mv1 ; n++){
            for(int m = 0 ; m <= mv2 ; m++){
                int count1 = 0;
                int count2 = 0;
                for(int i = 0 ; i < board_w ; i++){
                    for(int j = 0 ; j < board_w ; j++){
                        if(board1[i][j] != map[n+i][m+j])   count1++;
                        if(board2[i][j] != map[n+i][m+j])   count2++;
                    }
                }
                minValue = Math.min(minValue, Math.min(count1, count2));
            }
        }
            
        System.out.println(minValue);
        br.close();
    }

    // Gemini 개선 풀이
    // 주어진 체스판을 boolean으로 확인하여 매핑
    // 모두 칠해지는 경우인 64를 기준으로 최소 색칠 횟수를 찾음
    // 특정 위치를 왼쪽 위로 기준으로 하여 W시작이라 가정하고 같지않으면 count함
    // 반대로 B시작은 전체 색칠 횟수인 64에서 뺌으로써 두 값을 비교해 반환
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 메모리 낭비를 줄이기 위해 boolean 배열 사용 (W=true, B=false 로 가정하거나 char 배열 사용)
        boolean[][] board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                // 'W'이면 true, 'B'이면 false
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        int minChanges = 64; // 최대 변경 횟수는 64이므로 초기값 설정

        // 8x8 윈도우 슬라이딩
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minChanges = Math.min(minChanges, getSolution(i, j, board));
            }
        }

        System.out.println(minChanges);
    }

    // (x, y)를 시작점으로 8x8 체스판을 검사하는 메소드
    public static int getSolution(int x, int y, boolean[][] board) {
        int count = 0;
        
        // 여기서는 표준 패턴(맨 왼쪽 위가 W인 경우)을 기준으로 셉니다.
        // W가 true라고 가정했을 때:
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // (i+j)가 짝수면 시작점과 같은 색이어야 함(W), 홀수면 다른 색(B)
                // 아래 로직은 "체스판 규칙에 맞는지"가 아니라 "White 기준 패턴과 얼마나 다른지" 셉니다.
                boolean expected = ((i - x) + (j - y)) % 2 == 0; // true면 W여야 함 (상대좌표 기준)
                
                // 실제 보드의 값과 'W'기준 예상값이 다르면 칠해야 함
                if (board[i][j] != expected) { 
                    count++;
                }
            }
        }
        
        // count: W로 시작하는 체스판으로 만들기 위해 칠해야 하는 개수
        // 64 - count: B로 시작하는 체스판으로 만들기 위해 칠해야 하는 개수
        return Math.min(count, 64 - count);
    }
}