public class 안전지대 {
    public int solution(int[][] board) {
        int size = board.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == 1){
                    dangerArea(board, i, j);
                }
            }
        }
        
        int count = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
    public void dangerArea(int [][] board, int i, int j){
        int I = i;
        int J = j;
        for(i=I-1;i<=I+1;i++){
            for(j=J-1;j<=J+1;j++){
                if(i >= 0 && j >= 0 && i < board.length && j < board.length && board[i][j] != 1){
                    board[i][j] = 2;
                }
            }
        }
        
    }

    //Gemini를 통한 개선
    // 1. board 배열에 2로 위험지역을 표시하는 것은 실수를 야기할 수 있어 따로 이를 체크할 boolean 배열을 만듬
    // 2. 추후 풀 문제에서 방향 배열 방식은 중요하므로 익숙해지는게 좋음
    // 3. stream을 이용한다면 더욱 간결한 코드가 될 것임
    // 4. boolean 2차원 배열로 기존 board 배열 데이터를 보존함과 동시에 안전지대 확인할 때 용이하게 사용할 수 있음
    //      또한 boolean은 1비트 단위로 4바이트인 int 배열보다 메모리 측면에서 효율적임
    // 주변 8방향 + 자기 자신을 포함하는 좌표 변화량
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1, 0};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1, 0};

    public int solution1(int[][] board) {
        int n = board.length;
        // 위험 지역을 표시할 새로운 배열 (원본 보존을 위해 권장)
        boolean[][] isDanger = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    markDanger(isDanger, i, j, n);
                }
            }
        }

        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isDanger[i][j]) safeCount++;
            }
        }
        return safeCount;
    }

    private void markDanger(boolean[][] isDanger, int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                isDanger[nx][ny] = true;
            }
        }
    }
}
