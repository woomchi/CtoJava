package Programmerslv1;

public class 택배상자꺼내기 {
    // 나의 풀이
    // 직관적인 풀이 => 효율이 매우 떨어짐
    public int solution(int n, int w, int num) {
        int row = n/w;  int col = w;
        if(n%w != 0){
            row += 1;
        }

        // 지정된 상자 위치
        int x = 0;
        int y = 0;

        int [][] boxes = new int[row][col];
        int index = 1;
        int j = 0;
        for(int i = 0 ; i < row ; i++){
            if(j <= 0){
                j = 0;
                while(j < col){
                    if(index > n)   break;
                    if(index == num){
                        x = j;  y = i;
                    }
                    boxes[i][j] = index++;
                    j++;
                }
            }else if(j >= col){
                j = col-1;
                while(j >= 0){
                    if(index > n)   break;
                    if(index == num){
                        x = j;  y = i;
                    }
                    boxes[i][j] = index++;
                    j--;
                }
            }
        }

        int answer = 0;
        for(int i = y ; i < row ; i++){
            if(boxes[i][x] != 0)    answer++;
        }

        return answer;
    }

    // Gemini 개선 풀이
    // 단순 행과 열의 수학적 계산을 배열 생성 없이 O(1) 시간복잡도로 해결
    public int solutionGemini(int n, int w, int num) {
        int answer = 0;
        
        // 1. num의 위치(행, 열) 계산 (0-based index)
        int targetRow = (num - 1) / w;
        int targetCol = (num - 1) % w;
        
        // 홀수 행(1, 3, 5...)은 역순이므로 열 위치를 반전시킴
        if (targetRow % 2 == 1) {
            targetCol = w - 1 - targetCol;
        }

        // 2. 현재 행부터 마지막 행까지 같은 열(Column)에 있는 상자 확인
        // 최대 행의 개수 구하기
        int totalRows = (n - 1) / w + 1; 

        for (int r = targetRow; r < totalRows; r++) {
            int boxNumInThisRow;
            int startNum = r * w + 1; // 해당 행의 시작 숫자
            
            // 현재 행(r)이 짝수냐 홀수냐에 따라 해당 열(targetCol)의 값을 계산
            if (r % 2 == 0) {
                // 정방향: 시작수 + 열 인덱스
                boxNumInThisRow = startNum + targetCol;
            } else {
                // 역방향: 시작수 + (폭 - 1 - 열 인덱스)
                boxNumInThisRow = startNum + (w - 1 - targetCol);
            }

            // 3. 존재하는 상자인지 확인 (N 이하여야 함)
            if (boxNumInThisRow <= n) {
                answer++;
            }
        }

        return answer;
    }
}
