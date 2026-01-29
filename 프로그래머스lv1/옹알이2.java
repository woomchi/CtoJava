package 프로그래머스lv1;

public class 옹알이2 {
    // 나의 풀이
    // 이미 연속에 대해서 예외처리가 되었으므로 if문이 불필요함
    // "aya" 등을 하드코딩하기 보다는 배열에 저장하여 반복문으로 처리하는게 더 간결하고 좋음
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0 ; i < babbling.length; i++){
            String str = babbling[i];
            if(str.indexOf("ayaaya") != -1 || str.indexOf("yeye") != -1 ||
                str.indexOf("mama") != -1 || str.indexOf("woowoo") != -1)    continue;
            if(str.indexOf("aya") != -1){
                str = str.replace("aya", " ");
            }
            if(str.indexOf("ye") != -1){
                str = str.replace("ye", " ");
            }
            if(str.indexOf("ma") != -1){
                str = str.replace("ma", " ");
            }
            if(str.indexOf("woo") != -1){
                str = str.replace("woo", " ");
            }
            str = str.replaceAll(" ", "");
            if(str.equals(""))  answer++;
        }
        return answer;
    }

    // Gemini 개선 풀이
    public int solutionGemini(String[] babbling) {
        int answer = 0;
        // 발음 가능한 단어들을 배열로 관리
        String[] pronunciations = {"aya", "ye", "woo", "ma"};
        
        for (String str : babbling) {
            // 1. 연속된 발음("ayaaya" 등)이 포함되어 있으면 바로 건너뜀
            if (str.contains("ayaaya") || str.contains("yeye") || 
                str.contains("woowoo") || str.contains("mama")) {
                continue;
            }

            // 2. 발음 가능한 단어를 공백(" ")으로 치환
            // if문 체크 없이 바로 replace 호출 (없으면 변경되지 않음)
            for (String p : pronunciations) {
                str = str.replace(p, " ");
            }

            // 3. 공백을 모두 제거했을 때 빈 문자열이 되면 성공
            if (str.replace(" ", "").equals("")) {
                answer++;
            }
        }
        return answer;
    }

    // Gemini 개선 풀이 - 정규표현식 활용
    public int solutionGemini1(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            // 1. 연속된 발음이 있는 경우 제외
            if (str.contains("ayaaya") || str.contains("yeye") || 
                str.contains("woowoo") || str.contains("mama")) {
                continue;
            }
            
            // 2. aya, ye, woo, ma를 모두 빈 문자열("")로 치환
            // 주의: 여기서는 정규식으로 한 번에 처리하므로 "yayae" 같은 케이스 처리가 다를 수 있어
            // 질문자님의 '공백 치환' 방식이 사실 더 직관적이고 안전할 수 있습니다.
            
            // 아래는 질문자님의 로직을 정규식으로 구현한 것:
            // "aya", "ye", "woo", "ma" 만으로 구성되어 있는지 확인
            str = str.replaceAll("aya|ye|woo|ma", "");
            
            if (str.equals("")) answer++;
        }
        return answer;
    }
}
