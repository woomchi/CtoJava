package 프로그래머스lv1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    // 나의 풀이
    // 로직에 문제는 없지'만', 현대 자바에서는 Stack의 동기화로 인한 오버헤드 성능을 이유로 지양함
    // 되도록이면 Stack 대신 Deque 사용을 지향함 => 삽입 순서 상관없이 앞 뒤를 pop 할 수 있는데 결정적으로 기능은 같음
    // flag 변수로 인해 코드 이해의 비용이 발생한다면 이를 하나의 로직으로 합치는 게 좋음
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for(int i = 0 ; i < moves.length ; i++){
            int doll = -1;
            int index = moves[i]-1;
            for(int j = 0 ; j < board.length ; j++){
                if(board[j][index] != 0){
                    doll = board[j][index];
                    board[j][index] = 0;
                    break;
                }
            }

            if(doll != -1){
                if(!basket.isEmpty() && basket.peek() == doll){
                    basket.pop();
                    answer += 2;
                }else{
                    basket.push(doll);
                }
            }
        }
        return answer;
    }

    // Gemini 개선 풀이(리펙터링)
    public int solutionGemini(int[][] board, int[] moves) {
        int answer = 0;
        // 1. Stack 대신 ArrayDeque 사용 (더 빠르고 권장되는 방식)
        Deque<Integer> basket = new ArrayDeque<>();

        for (int move : moves) {
            int col = move - 1; // 0-based index 변환

            for (int row = 0; row < board.length; row++) {
                // 2. 인형이 있는 경우 바로 로직 처리
                if (board[row][col] != 0) {
                    int doll = board[row][col];
                    board[row][col] = 0; // 인형 집기 처리

                    // 3. 바구니 로직을 여기서 바로 수행 (불필요한 if문 깊이 감소)
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }

                    // 해당 열에서 작업을 마쳤으므로 루프 종료
                    break; 
                }
            }
        }
        return answer;
    }
}
