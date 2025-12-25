public class 다음에올숫자 {
    // 내 문제 풀이
    public int solution(int[] common) {
        return whichProgression(common);
    }

    private int whichProgression(int [] common){
        int len = common.length-1;
        int subtract1 = common[len]-common[len-1];
        int subtract2 = common[len-1]-common[len-2];
        if(subtract1 == subtract2){
            return common[len]+subtract1;
        }else{
            return common[len]*subtract1/subtract2;
        }
    }

    // Gemini의 개선
    // 가독성 측면에서 지역변수로 경우에 따른 알맞은 이름으로 선언함
    public int solution1(int[] common) {
    // 1. 등차수열인지 확인 (두 항의 차이가 일정한지)
    if ((common[1] - common[0]) == (common[2] - common[1])) {
        int diff = common[1] - common[0];
        return common[common.length - 1] + diff;
    } 
    // 2. 등비수열인 경우
    else {
        // 0으로 나누는 상황을 방지하기 위해 0번 인덱스가 0이 아닌지 체크하는 것이 좋지만,
        // 보통 문제 조건상 등비수열이면 common[0]은 0이 아닙니다.
        int ratio = common[1] / common[0];
        return common[common.length - 1] * ratio;
    }
}
}
