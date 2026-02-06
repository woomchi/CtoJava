package 프로그래머스lv1;

public class KaKaoBlind1차_비밀지도 {
    /* 핵심 로직 : 비트 연산자 '|' 를 통한 비트맵 연산 + String.format을 통한 지정된 형식 출력 */


    // 나의 풀이
    // 비트 연산과 StringBuilder를 이용해 효율적으로 문제를 풀이함
    // 다만, 라이브러리 메서드를 사용하지 않았다는 점에서 
    // 코드의 가독성이 format이나 toBinaryString 메서드를 사용한 코드에 비해 가독성이 좋지 않음
    // 추가로, 오히려 라이브러리 메서드를 잘 모른다는 실무의 효율성 부분에서 부족함을 느낄 수 있음
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 주어진 값 n 크기의 정사각형 지도
        int[] map = new int[n];
        for(int i = 0; i < n; i++){
            map[i] = arr1[i] | arr2[i];
        }

        String[] answer = new String[n];
        StringBuilder sb;
        for(int i = 0; i < n ; i++){
            sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(map[i]%2==1){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
                map[i] /= 2;
            }
            answer[i] = (sb.reverse()).toString();
        }
        return answer;
    }

    // Gemini 피드백 반영
    // 따로 map을 선언하지 않고 | 연산한 값을 직접적으로 사용함으로써 코드 간소화
    // 비트 시프트 연산을 통해 sb 내용을 뒤집을 필요 없음
    public String[] solutionGemini(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 1. 두 지도를 합침 (OR 연산)
            int combined = arr1[i] | arr2[i];
            
            StringBuilder sb = new StringBuilder();
            // 2. n-1부터 0까지 비트를 확인 (왼쪽 -> 오른쪽 순서)
            for (int j = n - 1; j >= 0; j--) {
                // 해당 위치(j)의 비트가 1인지 확인
                if (((combined >> j) & 1) == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    // Gemini 개선 풀이 - format 메서드와 toBinaryString 메서드 활용
    public String[] solutionGemini1(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 1. OR 연산 후 2진수 문자열로 변환
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

            // 2. 길이 맞추기 (앞쪽 공백 채우기)
            // %ns : n자리만큼 확보하고 문자열을 넣음 (왼쪽은 공백으로 채워짐)
            binary = String.format("%" + n + "s", binary);

            // 3. 1을 #으로, 0을 공백으로 치환
            // 포맷팅으로 생긴 공백(" ")과 원래 0인 부분("0")을 모두 처리해야 함
            binary = binary.replace("1", "#").replace("0", " ");
            
            answer[i] = binary;
        }
        return answer;
    }
}
