package 프로그래머스lv1;

public class 둘만의암호 {
    // 나의 풀이
    // 정확한 로직이지만 직관적이지 않음
    public String solution(String s, String skip, int index) {
        // 주어진 문자열을 index만큼 뒤의 알파벳으로 바꿈
        // 만약 z를 넘어가면 a로 순환함
        // skip에 명시된 알파벳은 건너뜀
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = 0 ; j < index ; j++){
                c++;
                if(c > 'z') c -= 26;
                while(skip.indexOf(c) != -1){
                    c++;
                    if(c > 'z') c -= 26;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // Gemini 개선 풀이
    // 3중 구조를 깬 O(1) 구조로 효율적임
    // 유효한 알파벳만 남기는 방식의 예외처리로 편하게 인덱싱할 수 있음 => 매우 직관적임
    public String solutionGemini(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        // 1. skip에 있는 문자를 제외한 '유효한 알파벳' 문자열 생성
        // 예: skip="wb", alphabet="acdefg...xyz" (b, w 제외됨)
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder validChars = new StringBuilder();
        
        for (char c : alphabet.toCharArray()) {
            if (skip.indexOf(c) == -1) {
                validChars.append(c);
            }
        }
        String validString = validChars.toString();
        int len = validString.length();

        // 2. s의 각 문자를 매핑
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 현재 문자가 유효한 알파벳 문자열에서 몇 번째인지 찾음
            int currentIdx = validString.indexOf(c);
            
            // index만큼 이동 후, 길이를 넘어가면 순환(%) 처리
            int newIdx = (currentIdx + index) % len;
            
            sb.append(validString.charAt(newIdx));
        }
        
        return sb.toString();
    }
}
