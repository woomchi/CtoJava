package 프로그래머스lv0;
public class 옹알이1 {
    // 나의 문제 풀이
    public int solution(String[] babbling) {
        int [] lens = new int[babbling.length];

        for(int i=0;i<babbling.length;i++){
            lens[i] = babbling[i].length();
            if(babbling[i].indexOf("aya") != -1){
                lens[i] -= 3;
            }
            if(babbling[i].indexOf("ye") != -1){
                lens[i] -= 2;
            }
            if(babbling[i].indexOf("woo") != -1){
                lens[i] -= 3;
            }
            if(babbling[i].indexOf("ma") != -1){
                lens[i] -= 2;
            }
        }

        int count = 0;
        for(int i=0;i<lens.length;i++){
            if(lens[i] == 0){
                count++;
            }
        }

        return count;
    }

    // 지적된 문제를 내 방식을 유지한채 수정한 코드
    public int modifiedsolution(String[] babbling) {
        int count = 0;
        for(String s: babbling){
            int len = s.length();
            if(s.indexOf("aya") != -1){
                len -= 3;
            }
            if(s.indexOf("ye") != -1){
                len -= 2;
            }
            if(s.indexOf("woo") != -1){
                len -= 3;
            }
            if(s.indexOf("ma") != -1){
                len -= 2;
            }
            if(len == 0) count++;
        }
        return count;
    }

    // 위에 대한 개선 코드
    public int modifiedsolution1(String[] babbling) {
    int count = 0;
    for (String s : babbling) {
        // 발음 가능한 단어들을 공백(" ")으로 치환
        // 빈 문자열("")이 아닌 공백으로 바꾸는 이유는 앞뒤 글자가 붙어서 새로운 단어가 되는 걸 막기 위함입니다.
        String temp = s.replace("aya", " ")
                       .replace("ye", " ")
                       .replace("woo", " ")
                       .replace("ma", " ");
        
        // 모든 공백을 제거했을 때 길이가 0이면 정답
        if (temp.trim().length() == 0) {
            count++;
        }
    }
    return count;
}

    // 다른 사람의 풀이
    public int solution1(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            var b = babbling[i];
            b = b.replace("aya", "1");
            b = b.replace("ye", "1");
            b = b.replace("woo", "1");
            b = b.replace("ma", "1");
            // 만약 즉각 aya / ye / woo / ma 를 ""(공백)으로 바꿨다면 사라지는 과정에서
            // 의도치않은 새로운 단어(aya, woo 등)으로 재탄생하여 원하지 않은 결과로 변모될 수 있음
            // => 따라서, 위 4가지 단어를 임시로 다른 글자로 바꿨다가 일괄적으로 없앰으로써 이를 방지함
            b = b.replaceAll("1", "");
            if (b.length() == 0) answer++;
        }
        return answer;
    }

    // Gemini의 개선
    // 기존 내 코드는 문제가 만약 중복 단어를 다룬다면 처리가 불가함
    // 또한, 문제에서 4가지 단어는 한번씩만 반복되지만, 만약 애매하게 반복되는 구조의 단어(ex. ayaya)가 나온다면 원치 않은 결과가 나올 수 있음
    // 마지막으로, 정수 배열을 사용하지 않고 지역변수를 통해 메모리를 더 절약할 수 있음
    public int solution2(String[] babbling) {
        int count = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String s : babbling) {
            int totalLen = s.length();
            int speakableLen = 0;

            for (String w : words) {
                if (s.contains(w)) {
                    speakableLen += w.length();
                }
            }

            if (totalLen == speakableLen) {
                count++;
            }
        }
        return count;
    }

    // Gemini 권장 방식 - 정규 표현식
    public int solution3(String[] babbling) {
    int answer = 0;
    for (String s : babbling) {
        // "aya", "ye", "woo", "ma" 중 하나가 1번 이상(+) 반복되어 
        // 문자열 전체(^)가 끝까지($) 일치하는지 확인
        if (s.matches("^(aya|ye|woo|ma)+$")) {
            answer++;
        }
    }
    return answer;
}
}
