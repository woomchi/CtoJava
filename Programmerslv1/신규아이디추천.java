package Programmerslv1;

public class 신규아이디추천 {
    /* 핵심 로직 : 정규표현식 활용 */

    // 나의 풀이
    // substring을 많이 사용하므로 효율이 떨어짐
    // 로직이 분리되지 않아 가독성이 떨어짐
    public String solution(String new_id) {
        final int LENMAX = 15;
        final int LENMIN = 3;
        String str = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9') ||
                '-' == ch || '_' == ch || '.' == ch){
                sb.append(ch);
            }
        }
        str = sb.toString();

        while(str.indexOf("..") != -1){
            str = str.replace("..", ".");
        }

        int begin = str.startsWith(".") == true ? 1 : 0;
        int end = str.endsWith(".") == true ? str.length()-1 : str.length();
        if(begin > end){
            str = str.substring(begin, begin);
        }else{
            if(end >= LENMAX+1){
                str = str.substring(begin, begin+LENMAX);
            }else{
                str = str.substring(begin,end);
            }
        }

        int len = str.length();
        sb = new StringBuilder();
        sb.append(str);
        while(sb.length() < LENMIN){
            if(len == 0){
                sb.append('a');
            }else{
                sb.append(str.charAt(len-1));
            }
        }
        if(sb.charAt(sb.length()-1) == '.'){
            sb = sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }

    // Gemini 개선 풀이 - 정규표현식 활용
    public String solutionGemini(String new_id) {
    // 1단계: 소문자 치환
    String str = new_id.toLowerCase();

    // 2단계: 알파벳, 숫자, -, _, . 제외하고 제거
    // (작성하신 for문 로직도 훌륭합니다. 정규식으로 하면 더 짧습니다)
    str = str.replaceAll("[^a-z0-9\\-_.]", "");

    // 3단계: 마침표 2번 이상 -> 하나로
    str = str.replaceAll("[.]{2,}", ".");

    // 4단계: 처음과 끝의 마침표 제거
    // ^[.] : 시작 부분의 점, [.]$ : 끝 부분의 점
    str = str.replaceAll("^[.]|[.]$", "");

    // 5단계: 빈 문자열이면 "a" 대입
    if (str.isEmpty()) {
        str = "a";
    }

    // 6단계: 16자 이상이면 15자로 자르기
    if (str.length() >= 16) {
        str = str.substring(0, 15);
        // 자른 후 끝에 마침표가 있다면 제거
        str = str.replaceAll("[.]$", "");
    }

    // 7단계: 2자 이하라면 마지막 문자 반복
    StringBuilder sb = new StringBuilder(str);
    while (sb.length() < 3) {
        sb.append(sb.charAt(sb.length() - 1));
    }

    return sb.toString();
}
}
