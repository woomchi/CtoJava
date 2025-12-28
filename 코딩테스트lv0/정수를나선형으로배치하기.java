package 코딩테스트lv0;
class 정수를나선형으로배치하기 {
    // 내 문제 풀이
    public int[][] solution(int n) {
        int[][] array = new int[n][n];
        return spiral(array,n);
    }

    private int[][] spiral(int [][] array, int n){
        int turn = 0;
        int len = n-1;
        int i = turn, j = turn;
        for(int index = 1;index<=n*n;index++){
            array[i][j] = index;
            if(i == turn && j < len-turn){
                j++;
            }else if(i < len-turn && j == len-turn){
                i++;
            }else if(i == len-turn && j > turn){
                j--;
            }else if(i > turn+1 && j == turn){
                i--;
            }
            if(i == turn+1 && j == turn){
                turn++;
            }
        }
        return array;
    }

    //Gemini의 개선
    public int[][] solution1(int n) {
        int[][] array = new int[n][n];
        fillSpiral(array, n);
        return array;
    }

    private void fillSpiral(int[][] array, int n) {
        // 1. 방향 정의 (우, 하, 좌, 상)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = 0, y = 0, dir = 0;
        
        for (int num = 1; num <= n * n; num++) {
            array[x][y] = num;
            
            // 다음에 이동할 위치 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 2. 방향 전환 조건: 범위를 벗어나거나 이미 값이 채워진 경우
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || array[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 방향 전환 (0->1->2->3->0)
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
    }
}