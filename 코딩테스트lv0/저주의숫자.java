package 코딩테스트lv0;

public class 저주의숫자 {
    // 나의 풀이
    // 변수가 많다보니 로직이 복잡해져서 관리가 어려움
    public int solution(int n) {
        // 3의 배수 혹은 '3'이 포함된 값을 세고 나온 값만큼 더 반복하고 거기서 나온 조건에 해당하는 값을 또 구하는 식
        int count = 0;
        while(true){
            int tempCount = 0;
            for(int i=1;i<=n+count;i++){
                if(i%3==0 || (String.valueOf(i)).contains("3")){
                    tempCount++;
                }
            }
            if(tempCount==count)    break;
            count = tempCount;
        }
        int answer = n + count; 
        return answer;
    }

    //Gemini 개선 풀이
    // 이전에 비슷한 방식을 사용했는데 while을 생각해보지 못함...
    // 항상 for문 안에는 for문, 이버넹 기껏 새로운 while문 안에 for문 형태를 짜본 건데...
    public int solutionGemini(int n) {
        int answer = 0;

        // 1. 매개변수 n번만큼 반복하며 유효한 숫자를 찾습니다.
        for (int i = 0; i < n; i++) {
            answer++; // 다음 숫자로 이동

            // 2. 만약 현재 answer가 '3의 배수'이거나 '3을 포함'한다면,
            //    유효한 숫자가 나올 때까지 계속 증가시킵니다.
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
        }
        
        return answer;
    }
}
