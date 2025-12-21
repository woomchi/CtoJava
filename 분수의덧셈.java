class Solution {
    //나의 풀이 방식
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        //int [] fracs = {numer1, denom1, numer2, denom2}; 불필요한 부분 삭제
        int numerSum = numer1 * denom2 + numer2 * denom1;
        int denomSum = denom1 * denom2;
        int [] fraction = {numerSum, denomSum};
        return lcm(fraction);
    }

    private int [] lcm(int [] fraction){
        int index = 2;
        while(index<1000){
            if(fraction[0]%index == 0 && fraction[1]%index == 0){
                fraction[0] /= index;
                fraction[1] /= index;
                index = 2;
            }else{
                index++;
            }
        }
        return fraction;
    }
    
    //나의 풀이 개선
    public int[] solution1(int numer1, int denom1, int numer2, int denom2) {
        int numerSum = numer1 * denom2 + numer2 * denom1;
        int denomSum = denom1 * denom2;
        int [] fraction = {numerSum, denomSum};
        return lcm1(fraction);
    }

    private int [] lcm1(int [] fraction1){
        int index = 2;
        while(index<1000){
            if(fraction1[0]%index == 0 && fraction1[1]%index == 0){
                fraction1[0] /= index;
                fraction1[1] /= index;
                index = 2;
            }else{
                index++;
            }
        }
        return fraction1;
    }

    //Gemini의 개선
    public int[] solution2(int numer1, int denom1, int numer2, int denom2) {
    // 1. 분수 더하기 (통분)
    int numerSum = numer1 * denom2 + numer2 * denom1;
    int denomSum = denom1 * denom2;

    // 2. 최대공약수(GCD) 구하기
    int gcd = getGCD(numerSum, denomSum);

    // 3. 최대공약수로 나누어 기약분수 만들기
    return new int[] { numerSum / gcd, denomSum / gcd };
}

// 유클리드 호제법을 이용한 GCD 계산 : 큰 수를 작은 수로 나눌 때 나머지가 0이 될때까지 이를 반복함
private int getGCD(int a, int b) {
    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

}