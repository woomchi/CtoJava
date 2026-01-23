package 코딩테스트lv0;

public class 치킨쿠폰 {
    public int solution(int chicken) {
        int coupon = chicken;
        int remain = 0;
        while(chicken>0){
            coupon += chicken/10;
            remain += chicken%10;
            if(remain/10!=0){
                coupon += remain/10;
                remain %= 10;
            }
            chicken /= 10;
        }
        return coupon/10;
    }

    // Gemini 개선 풀이
    // 문제에서 상태를 단순화함으로써 불필요한 변수를 줄여야함 => 주인공 변수를 하나 설정해 이를 토대로 흐름을 정함
    // 문제를 현실 세계의 흐름처럼 분석하기
    public int solutionGemini(int chicken) {
        int answer = 0;  // 총 서비스 치킨 수
        int coupons = chicken; // 현재 가지고 있는 쿠폰

        while (coupons >= 10) {
            int newServiceChicken = coupons / 10; // 새로 시킨 서비스 치킨
            int remainingCoupons = coupons % 10;  // 치킨 시키고 남은 쿠폰
            
            answer += newServiceChicken;
            
            // 중요: 서비스 치킨을 시키면 '새 쿠폰'이 또 생깁니다!
            coupons = newServiceChicken + remainingCoupons;
        }

        return answer;
    }
}
