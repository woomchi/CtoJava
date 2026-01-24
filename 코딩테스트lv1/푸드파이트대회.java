package 코딩테스트lv1;

public class 푸드파이트대회 {
    //나의 풀이
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbR = new StringBuilder();
        for(int i=1;i<food.length;i++){
            for(int count = 0;count<food[i]/2;count++){
                sb.append(i);
                sbR.append(i);
            }
        }
        sb.append("0"+sbR.reverse());
        return sb.toString();
    }

    // Gemini 개선 풀이 - java11 버전 이상부터
    public String solutionGemini(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        // 1. 왼쪽 음식 배치
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            // repeat 메서드는 Java 11 이상부터 지원 (코딩테스트 환경 확인 필요)
            // Java 8 이하 환경이라면 기존처럼 반복문 사용 권장
            sb.append(String.valueOf(i).repeat(count));
        }
        
        // 2. 현재까지 만든 문자열(왼쪽)을 임시 저장
        String leftSide = sb.toString();
        
        // 3. 물(0) 추가
        sb.append("0");
        
        // 4. 왼쪽 문자열을 뒤집어서 오른쪽에 추가
        // StringBuilder를 새로 생성하여 reverse 후 추가
        sb.append(new StringBuilder(leftSide).reverse());
        
        return sb.toString();
    }

    // Gemini 개선 풀이 - 나의 풀이 개선
    public String solutionGemini1(int[] food) {
        StringBuilder sb = new StringBuilder();

        // 1. 왼쪽 부분 생성
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        // 2. 결과 조합: (왼쪽) + "0" + (왼쪽을 뒤집은 것)
        // sb를 toString()으로 변환 후 다시 StringBuilder에 넣어 뒤집습니다.
        return sb.toString() + "0" + sb.reverse().toString();
    }
}
