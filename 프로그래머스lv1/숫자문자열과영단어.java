package 프로그래머스lv1;

public class 숫자문자열과영단어 {
    /* 핵심 로직 : 문자열 매핑 + replace로 변경 */

    // 나의 풀이
    // 정확성과 가독성 측면에서는 좋음
    // 다만, String이 불변 객체이기 때문에 메모리 사용량이 높아질 수 있으므로 StringBuilder가 더 좋음
    // 그리고 현실적으로 코딩 테스트에서 빠르게 문제 풀이하기에는 무리가 있음
    // 따라서, 이러한 방식으로 만드는 것도 좋지'만', '배열 매핑'이 간결한 코드를 만들기에 좋음
    class Solution {
        enum Number{
            zero("0", "zero"),
            one("1", "one"),
            two("2", "two"),
            three("3", "three"),
            four("4", "four"),
            five("5", "five"),
            six("6", "six"),
            seven("7", "seven"),
            eight("8", "eight"),
            nine("9", "nine");

            private final String val;
            private final String num;

            private static final Number[] NUMBER_LIST = values();

            Number(String val, String num){
                this.val = val;
                this.num = num;
            }

            public static String stringToNumber(String s){
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                for(Number n : NUMBER_LIST){
                    sb = sb.replace(sb.indexOf(n.num), sb.indexOf(n.num)+n.num.length()-1, n.val);
                }
                return s;
            }
        }
        public int solution(String s) {
            return Integer.parseInt(Number.stringToNumber(s));
        }
    }

    // 나의 리펙터링 - StringBuilder 활용
    enum Number{
        zero("0", "zero"),
        one("1", "one"),
        two("2", "two"),
        three("3", "three"),
        four("4", "four"),
        five("5", "five"),
        six("6", "six"),
        seven("7", "seven"),
        eight("8", "eight"),
        nine("9", "nine");

        private final String val;
        private final String num;

        private static final Number[] NUMBER_LIST = values();

        Number(String val, String num){
            this.val = val;
            this.num = num;
        }

        public static String stringToNumber(String s){
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            for(Number n : NUMBER_LIST){
                int index = 0;
                while((index = sb.indexOf(n.num)) != -1){
                    sb = sb.replace(index, index+n.num.length(), n.val);
                }
                    
            }
            return sb.toString();
        }
    }
    public int solution1(String s) {
        
        return Integer.parseInt(Number.stringToNumber(s));
    }

    // Gemini 개선 풀이
    // ??? 갑자기 줄이 줄어들었다~
    public int solution(String s) {
        String[] numWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < numWords.length; i++) {
            // "zero" -> "0", "one" -> "1" ...
            // i를 문자열로 변환하여 대체
            s = s.replace(numWords[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}
