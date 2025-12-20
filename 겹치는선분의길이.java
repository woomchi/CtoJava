public class 겹치는선분의길이 {
    public int solution(int[][] lines) {
        int start = getMaxStart(lines);
        int end = getMinEnd(lines);
        if(end > start){
            System.out.println("0");
            return lineLength(lines[0], lines[1], lines[2]) - (end-start)*2;
        }else{
            System.out.println("1");
            return lineLength(lines[0], lines[1], lines[2]);
        }

    }

    public int lineLength(int [] l1, int [] l2, int [] l3){
        return overlapLine(l1, l2) + overlapLine(l2, l3) + overlapLine(l1,l3);
    }

    public int overlapLine(int [] l1, int [] l2){
        if(l1[0] < l2[0] && l2[0] < l1[1]){
            if(l1[0] < l2[1] && l2[1] < l1[1]){
                return l2[1] - l2[0];
            }else{
                return l1[1] - l2[0];
            }
        }else if(l1[0] < l2[1] && l2[1] < l1[1]){
            return l2[1] - l1[0];
        }else if(l2[0] < l1[0] && l1[1] < l2[1]){
            return l1[1] - l1[0];
        }else if(l1[0] == l2[0] && l1[1] == l2[1]){
            return l1[1] - l1[0];
        }
        return 0;
    }

    public int getMaxStart(int [][] lines){
        int maxStart = lines[0][0];
        for(int i=0;i<lines.length;i++){
            if(maxStart < lines[i][0]){
                maxStart = lines[i][0];
            }
        }
        return maxStart;
    }

    public int getMinEnd(int [][] lines){
        int minEnd = lines[0][1];
        for(int i=0;i<lines.length;i++){
            if(minEnd > lines[i][1]){
                minEnd = lines[i][1];
            }
        }
        return minEnd;
    }

    // Gemini의 개선
    // 1. 기하학적인 풀이로 수학적으론 문제없지만 선분의 개수에 따라 조건문이 복잡해질 수 있음 
    // 2. 주어진 수학 도구 클래스 메서드를 적극적으로 사용하기(이 부분은 공부가 필요)
    // 조언 : 문제에 주어진 조건을 잘 살펴보고 계산하기 용이한 방식을 생각해 해결하기
    public int solution1(int[][] lines) {
        // 1. 선분이 나타날 수 있는 범위만큼 배열 생성 (-100 ~ 100이므로 200 칸)
        int[] road = new int[200];

        for (int[] line : lines) {
            // 음수 좌표를 양수 인덱스로 바꾸기 위해 +100 (오프셋)
            int start = line[0] + 100;
            int end = line[1] + 100;

            // 시작점부터 끝점 직전까지 1씩 더함 (선분의 '길이'를 체크하기 위함)
            for (int i = start; i < end; i++) {
                road[i]++;
            }
        }

        // 2. 배열을 돌면서 2 이상인 구간(2개 이상의 선분이 지나간 곳)의 개수를 셈
        int answer = 0;
        for (int count : road) {
            if (count >= 2) answer++;
        }

        return answer;
    }
}
