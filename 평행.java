public class 평행 {
    // 나의 문제 풀이
    public int solution(int[][] dots) {
        int len = dots.length;
        for(int i=1;i<len;i++){
            double gradient1 = (double)(dots[i][1] - dots[0][1])/(dots[i][0] - dots[0][0]);
            double gradient2 = (double)(dots[len-i/2-i%2][1] - dots[len-i/2-2][1])/(dots[len-i/2-i%2][0] - dots[len-i/2-2][0]);
            if(gradient1 == gradient2) return 1;
        }
        return 0;
    }

    // 내가 개선한 풀이
    public int modifiedsolution(int[][] dots) {
        if(compareGradient(dots[0], dots[1], dots[2], dots[3])){
            return 1;
        }
        if(compareGradient(dots[0], dots[2], dots[1], dots[3])){
            return 1;
        }
        if(compareGradient(dots[0], dots[3], dots[1], dots[2])){
            return 1;
        }
        return 0;
    }

    public boolean compareGradient(int [] d1, int [] d2, int [] d3, int [] d4){
        // Gemini 피드백 : 입력 좌표값이 커서 오버플로우가 발생하는 것을 방지하기 위해 long으로 형변환하여 이를 방지할 수 있음
        return (long)(d2[1]-d1[1])*(d4[0]-d3[0]) == (long)(d2[0]-d1[0])*(d4[1]-d3[1]);
    }
    
    // Gemini의 개선
    // 위의 인덱스 방식은 가독성이 떨어짐
    // double형으로 나눗셈 연산하면 문제없지만, 다른 자료형의 경우 오차가 발생함에 따라 코드의 정확성이 떨어짐
    public int solution1(int[][] dots) {
        int[][] pairs = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};

        for (int[] p : pairs) {
            if (isParallel(dots[p[0]], dots[p[1]], dots[p[2]], dots[p[3]])) {
                return 1;
            }
        }
        return 0;
    }

    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        // (b.y - a.y) * (d.x - c.x) == (d.y - c.y) * (b.x - a.x)
        return (long)(b[1] - a[1]) * (d[0] - c[0]) == (long)(d[1] - c[1]) * (b[0] - a[0]);
    }
}
