package Programmerslv1;

public class 지폐접기 {
    /* 핵심 로직 : 지갑과 지폐의 최대 최소를 조건에 맞으면 반복문 탈출 */ 

    // 나의 풀이
    // 주석이 너무 불친절해서 좀 다듬을 필요있음
    // 조건문의 가독성이 떨어짐 => 통일된 혹은 명확한 단어의 변수를 사용하는게 좋음
    public int solution(int[] wallet, int[] bill) {
        // 길이가 홀수라면 나눗셈(/)으로 처리
        // 지폐의 짧은 쪽을 지갑의 짧은 쪽보다 클 때
        // 지폐의 긴쪽이 지갑의 긴쪽보다 클 때
        int answer = 0;
        while(Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || 
              Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])){
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }

    //Gemini 개선풀이
    public int solutionGemini(int[] wallet, int[] bill) {
    int answer = 0;
    // 원본 보호를 위해 복사해서 사용 (코딩테스트에선 필수는 아님)
    int[] currentBill = bill.clone(); 
    
    while (true) {
        int billMin = Math.min(currentBill[0], currentBill[1]);
        int billMax = Math.max(currentBill[0], currentBill[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);

        // 지갑에 들어간다면 반복 종료
        if (billMin <= walletMin && billMax <= walletMax) {
            break;
        }

        // 더 긴 쪽을 반으로 접음
        if (currentBill[0] > currentBill[1]) {
            currentBill[0] /= 2;
        } else {
            currentBill[1] /= 2;
        }
        answer++;
    }
    return answer;
}
}
