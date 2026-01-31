package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이얼 {
    // 나의 풀이
    // 수학적 공식을 사용하여 코드가 간략하지만, 조건문이 섞여 가독성이 떨어짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int sum = 0;
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) <= 'O'){
                sum += 3 + (str.charAt(i)-'A')/3;
            }else{
                if(str.charAt(i) <= 'S'){
                    sum += 8;
                }else if(str.charAt(i) <= 'V'){
                    sum += 9;
                }else{
                    sum += 10;
                }
            }
        }
        System.out.println(sum);
        br.close();
    }

    // Gemini 개선 풀이
    // 다이얼 문제는 규칙이 불규칙하므로 하드코딩하거나 매핑을 이용하는 것이 직관적임
    public static void solutionGemini(String[] args) throws IOException {
        // 입력 속도 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Lookup Table: A부터 Z까지 걸리는 시간 미리 정의
        // A,B,C=3초 | D,E,F=4초 ... | W,X,Y,Z=10초
        int[] times = {
            3, 3, 3,       // A B C
            4, 4, 4,       // D E F
            5, 5, 5,       // G H I
            6, 6, 6,       // J K L
            7, 7, 7,       // M N O
            8, 8, 8, 8,    // P Q R S
            9, 9, 9,       // T U V
            10, 10, 10, 10 // W X Y Z
        };

        String str = br.readLine();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            // 문자를 인덱스로 변환 ('A' -> 0, 'B' -> 1 ...)
            sum += times[str.charAt(i) - 'A'];
        }

        System.out.println(sum);
        br.close();
    }

    // Gemini 개선풀이 - Enum 활용
    // 1. Enum 정의
    enum Dial {
        ABC(3, "ABC"),
        DEF(4, "DEF"),
        GHI(5, "GHI"),
        JKL(6, "JKL"),
        MNO(7, "MNO"),
        PQRS(8, "PQRS"),
        TUV(9, "TUV"),
        WXYZ(10, "WXYZ");

        private final int seconds;
        private final String mapping;

        // ⭐ 핵심 최적화 포인트 ⭐
        // values()를 호출할 때마다 배열 복사(clone)가 일어나므로,
        // 클래스가 로딩될 때 딱 한 번만 호출해서 '상수(static final)'에 저장해둡니다.
        private static final Dial[] CACHED_VALUES = values();

        Dial(int seconds, String mapping) {
            this.seconds = seconds;
            this.mapping = mapping;
        }

        // 문자를 받아서 시간을 반환하는 메서드
        public static int getSeconds(char c) {
            // values() 대신 미리 저장해둔 CACHED_VALUES 배열을 사용합니다.
            // 이러면 반복문이 돌 때마다 불필요한 배열 복사가 발생하지 않습니다.
            for (Dial d : CACHED_VALUES) {
                if (d.mapping.indexOf(c) != -1) {
                    return d.seconds;
                }
            }
            return 0; // 예외 처리 (문제 조건상 도달하지 않음)
        }
    }
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
        String str = br.readLine();
        int sum = 0;

        // 메인 로직은 매우 깔끔해집니다.
        for (int i = 0; i < str.length(); i++) {
            sum += Dial.getSeconds(str.charAt(i));
        }

        System.out.println(sum);
        br.close();
        }
}
