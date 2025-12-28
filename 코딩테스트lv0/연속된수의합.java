package 코딩테스트lv0;
public class 연속된수의합 {
        public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int left = total / num;
        int plus;
        if(num%2 == 1){
            plus = left - num/2;
        }else{
            plus = left - num/2 + 1;
        }
        
        for(int i=0;i<num;i++){
            answer[i] = plus;
            plus++;
        }
        return answer;
    }

    // Gemini의 개선
    // 수학적 논리에 근거해 공식화한 수식을 코드화함
    public int[] solution1(int num, int total) {
        int[] answer = new int[num];
        
        // 연속된 수의 시작값(x)을 공식으로 계산
        // (total - (0부터 num-1까지의 합)) / num
        int start = (total - (num * (num - 1) / 2)) / num;
        
        for (int i = 0; i < num; i++) {
            answer[i] = start + i;
        }
        
        return answer;
    }
}
