package 프로그래머스lv0;

import java.util.StringTokenizer;

public class 다항식더하기 {
    // 나의 풀이
    // 구분자를 " + "로 사용하면 공백이 없는 문자열을 쪼갤 때 정확히 처리되지 않을 수 있다.
    // 값이 전부 0일 때 0으로 반환하지 않음
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial, " + ");
        int coef = 0;           // 계수
        int constant = 0;       // 상수
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if(str.contains("x") && !(str.equals("x"))){
                coef += Integer.parseInt(str.substring(0,str.indexOf("x")));
            }else if(str.equals("x")){
                coef++;
            }else{
                constant += Integer.parseInt(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(coef!=0){
            if(coef!=1){
                sb.append(coef);
            }
            sb.append('x');
            if(constant!=0){
                sb.append(" + "+constant);
            }
        }else{
            if(constant!=0){
                sb.append(constant);
            }
        }


        return sb.toString();
    }

    // Gemini 개선 풀이
    // 가독성 측면에서 중첩 반복문을 계수와 상수항으로 분리해 개선함
    public String solutionGemini(String polynomial) {
    int xCount = 0; // x의 계수 합
    int num = 0;    // 상수의 합

    // " + " 문자열을 기준으로 분리 (정규식 이스케이프 필요)
    String[] parts = polynomial.split(" \\+ ");

    for (String part : parts) {
        if (part.contains("x")) {
            // "x"인 경우와 "3x"인 경우 분리
            if (part.equals("x")) {
                xCount += 1;
            } else {
                // "3x" -> "3"만 추출하여 파싱
                xCount += Integer.parseInt(part.replace("x", ""));
            }
        } else {
            // 상수인 경우
            num += Integer.parseInt(part);
        }
    }

    StringBuilder sb = new StringBuilder();

    // 1. x항 처리
    if (xCount > 0) {
        if (xCount == 1) {
            sb.append("x");
        } else {
            sb.append(xCount).append("x");
        }
    }

    // 2. 상수항 처리
    if (num > 0) {
        // 이미 x항이 있다면 앞에 " + "를 붙여줌
        if (sb.length() > 0) {
            sb.append(" + ");
        }
        sb.append(num);
    }
    
    // 3. 결과가 "0"인 경우 처리 (xCount=0, num=0)
    if (sb.length() == 0) {
        return "0";
    }

    return sb.toString();
}
}
