package 백준;
import java.io.*;

class NQueen{
    // Gemini 피드백 코드
    // 기존 2차원 배열 코드는 매번 값을 기록하고 지우는 과정으로
    // 메모리 사용량과 효율성 측면에서 떨어짐

    // 유망성 검사 로직 활용
    static int count = 0;
    static int [] board;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N];

        dfs(0);
        System.out.println(count);
        br.close();
    }
    
    public static void dfs(int depth){
        if(depth == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;
            
            if (isValidate(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean isValidate(int col) {
        for (int i = 0; i < col; i++) {
            // 0 ~ depth 범위 내에 이전에 위치시킨 기물이 있는지 확인(이전 기물과 같은 열인지)
            if (board[col] == board[i]) {
                return false;
            }
            // x와 y의 차(기울기)가 같다면 대각선에 위치한 것이므로 false 반환
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        // 같은 열과 대각선 모두 충돌하지 않으므로, 기물을 놓을 수 있음
        return true;
    }
}