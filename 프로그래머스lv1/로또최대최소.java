package 프로그래머스lv1;
import java.util.*;

class 로또최대최소{
    // 나의 풀이
    // 로직상 문제는 없지만, 가독성 측면에서 아쉬움
    // 순위 결정 매핑이 직관적이지 않음
    // list로 순회하기 보다 반복문을 묶어서 한 번에 처리하면 좋음
    public int[] solution(int[] lottos, int[] win_nums) {
        int [] win = { 0, 1, 2, 3, 4 ,5 , 6, 6 };
        int countZero = 0;
        for(int i : lottos){
            if(i == 0)  countZero++;
        }

        int count = 0;
        List<Integer> list = new ArrayList<>(win_nums.length+1);
        for(int i : win_nums)   list.add(i);
        for(int i : lottos){
            if(list.contains(i))    count++;
        }

        int minValue = count;
        int maxValue = count + countZero;

        int[] answer = new int[2];
        answer[0] = win[7 - maxValue];
        answer[1] = win[7 - minValue];

        return answer;
    }

    // Gemini 개선 풀이
    public int[] solutionGemini(int[] lottos, int[] win_nums) {
    // 1. 맞은 개수에 따른 순위 매핑 (인덱스: 맞은 개수, 값: 순위)
    // 0개 맞음 -> 6등, 1개 맞음 -> 6등, ..., 6개 맞음 -> 1등
        int[] rankMap = {6, 6, 5, 4, 3, 2, 1};

        int zeroCount = 0;
        int matchCount = 0;

        // 2. 0의 개수와 당첨 번호 일치 여부 확인
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue; // 0이면 당첨 번호 비교 불필요
            }
            
            // win_nums가 6개로 고정이므로 이중 반복문도 충분히 빠르고 효율적임
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    matchCount++;
                    break;
                }
            }
        }

        // 3. 최고 순위와 최저 순위 계산
        // 최고: 0인 숫자가 모두 당첨 번호라고 가정 (match + zero)
        // 최저: 0인 숫자가 모두 꽝이라고 가정 (match)
        int maxRank = rankMap[matchCount + zeroCount];
        int minRank = rankMap[matchCount];

        return new int[] {maxRank, minRank};
    }
}
