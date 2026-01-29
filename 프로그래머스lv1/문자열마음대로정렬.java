package 프로그래머스lv1;
import java.util.*;

public class 문자열마음대로정렬 {
    // 나의 풀이
    // 정석적인 버블 정렬 알고리즘이지만, 효율적이지 못함
    public String[] solution(String[] strings, int n) {
        for (int j = 0; j < strings.length; j++) { // 바깥 루프 (횟수용)
            for (int i = 0; i < strings.length - 1; i++) {
                
                char c1 = strings[i].charAt(n);
                char c2 = strings[i+1].charAt(n);

                // 1. n번째 문자가 앞쪽이 더 크면 바꿈
                if (c1 > c2) {
                    String temp = strings[i];
                    strings[i] = strings[i+1];
                    strings[i+1] = temp;
                } 
                // 2. n번째 문자가 같으면 전체 사전순 비교
                else if (c1 == c2) {
                    if (strings[i].compareTo(strings[i+1]) > 0) {
                        String temp = strings[i];
                        strings[i] = strings[i+1];
                        strings[i+1] = temp;
                    }
                }
            }
        }
        return strings;
    }

    // Gemini 개선 풀이 - charAt 메서드 사용
    // charAt 메서드는 substring 메서드에 비해 메모리 측면에서 효율적이고 compare 메서드를 여러 번 사용하지 않아도됨
    public String[] solutionGemini(String[] strings, int n) {
        for (int j = 0; j < strings.length; j++) { // 바깥 루프 (횟수용)
            for (int i = 0; i < strings.length - 1; i++) {
                
                char c1 = strings[i].charAt(n);
                char c2 = strings[i+1].charAt(n);

                // 1. n번째 문자가 앞쪽이 더 크면 바꿈
                if (c1 > c2) {
                    String temp = strings[i];
                    strings[i] = strings[i+1];
                    strings[i+1] = temp;
                } 
                // 2. n번째 문자가 같으면 전체 사전순 비교
                else if (c1 == c2) {
                    if (strings[i].compareTo(strings[i+1]) > 0) {
                        String temp = strings[i];
                        strings[i] = strings[i+1];
                        strings[i+1] = temp;
                    }
                }
            }
        }
        return strings;
    }
    
    // Gemini 개선 풀이 -비교자 & 함수형 인터페이스
    // Arrays.sort의 비교자를 함수형 인터페이스로 정의해서 이 기준에 따라 정렬함
    // Comparable 인터페이스 혹은 Comparator를 구현하는 것은 번거롭기 때문에 이렇게 함수형 인터페이스인 람다식으로 간략하게 구현할 수 있음
    public String[] solutionGemini1(String[] strings, int n) {
        // Arrays.sort를 사용하며, 정렬 기준(Comparator)을 람다식(함수형 인터페이스)으로 정의
        Arrays.sort(strings, (s1, s2) -> {
            
            // 1. n번째 문자가 다르면, 그 문자끼리 비교해서 정렬
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n); // char끼리 뺄셈으로 대소 비교
            }
            
            // 2. n번째 문자가 같으면, 문자열 전체를 사전순으로 비교
            return s1.compareTo(s2);
        });
        
        return strings;
    }
}
