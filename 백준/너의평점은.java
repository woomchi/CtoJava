package 백준;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class 너의평점은{
    // 나의 풀이
    // enum 선언에 실패하여 HashMap 방식을 사용함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> marks = new HashMap<>();
        marks.put("A+", 4.5);    marks.put("A0", 4.0);
        marks.put("B+", 3.5);    marks.put("B0", 3.0);
        marks.put("C+", 2.5);    marks.put("C0", 2.0);
        marks.put("D+", 1.5);    marks.put("D0", 1.0);
        marks.put("F", 0.0);
        
        double totalAvg = 0;
        double totalScore = 0;
        
        String str;
        while((str = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(str);
            if(!st.hasMoreTokens())    break;
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P")){
                totalAvg += score * marks.get(grade);
                totalScore += score;
            }
        }
        System.out.printf("%.6f", totalAvg/totalScore);
        br.close();
    }

    // 나의 기존 enum 풀이
    enum Marks {
        A_PLUS("A+", 4.5), A0("A0", 4.0),
        B_PLUS("B+", 3.5), B0("B0", 3.0),
        C_PLUS("C+", 2.5), C0("C0", 2.0),
        D_PLUS("D+", 1.5), D0("D0", 1.0),
        F("F", 0.0),
        P("P", 0.0); // P도 일단 정의하되, 점수는 0.0 (계산시 제외 로직은 별도)

        private final String grade;
        private final double score;

        Marks(String grade, double score) {
            this.grade = grade;
            this.score = score;
        }

        public double getScore() {
            return score;
        }

        // 2. 검색 속도 최적화를 위한 캐싱 (O(1))
        private static final Marks [] marks = values();

        public static double from(String s) {
            for(Marks m : marks){
                if(m.grade.equals(s))   return m.score;
            }
            return 0.0;
        }
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        double totalAvg = 0;
        double totalScore = 0;
        
        String str;
        while((str = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(str);
            if(!st.hasMoreTokens())    break;
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P")){
                totalAvg += score * Marks.from(grade);
                totalScore += score;
            }
        }
        System.out.printf("%.6f", totalAvg/totalScore);
        br.close();
    }

    // Gemini 개선풀이
    enum Grade {
        A_PLUS("A+", 4.5), A0("A0", 4.0),
        B_PLUS("B+", 3.5), B0("B0", 3.0),
        C_PLUS("C+", 2.5), C0("C0", 2.0),
        D_PLUS("D+", 1.5), D0("D0", 1.0),
        F("F", 0.0),
        P("P", 0.0); // P도 일단 정의하되, 점수는 0.0 (계산시 제외 로직은 별도)

        private final String label;
        private final double score;

        Grade(String label, double score) {
            this.label = label;
            this.score = score;
        }

        public double getScore() {
            return score;
        }

        // 2. 검색 속도 최적화를 위한 캐싱 (O(1))
        private static final Map<String, Grade> BY_LABEL = 
            Collections.unmodifiableMap(
                Stream.of(values())
                      .collect(Collectors.toMap(g -> g.label, g -> g))
            );

        public static Grade from(String label) {
            return BY_LABEL.get(label);
        }
    }

    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double totalSum = 0;    // (학점 × 과목평점)의 합
        double totalCredit = 0; // 학점의 총합

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            st.nextToken(); // 과목명은 필요 없으므로 패스
            
            double credit = Double.parseDouble(st.nextToken()); // 학점 (예: 3.0)
            String gradeLabel = st.nextToken(); // 등급 (예: A+)

            // 3. Enum을 통해 등급 객체를 가져옴
            Grade grade = Grade.from(gradeLabel);

            // P 등급이면 계산 제외
            if (grade == Grade.P) {
                continue;
            }

            totalSum += credit * grade.getScore();
            totalCredit += credit;
        }

        // 0으로 나누기 방지 (문제 조건상 없겠지만 안전하게)
        if (totalCredit == 0) {
            System.out.println(0.0);
        } else {
            System.out.printf("%.6f", totalSum / totalCredit);
        }
        
        br.close();
    }
}