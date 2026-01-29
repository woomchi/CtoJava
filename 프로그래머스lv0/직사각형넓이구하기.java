package 프로그래머스lv0;

public class 직사각형넓이구하기 {
    // 나의 문제 풀이
    // 불필요한 반복문이 존재함
    // 굳이 가로 세로를 매번 구할 필요없이 최소의 점과 최대의 점만 구하여 이를 뺌으로써 간단히 구할 수 있다.
    public int solution(int[][] dots) {
        int width = 0;
        int height = 0;
        for(int i=0;i<dots.length-1;i++){
            if(dots[i+1][0] - dots[i][0]!=0){
                width = Math.abs(dots[i+1][0] - dots[i][0]);
            }
            if(dots[i+1][1] - dots[i][1]!=0){
                height = Math.abs(dots[i+1][1] - dots[i][1]);
            }
        }
        return height * width;
    }

    //Gemini 개선 풀이
    public int solutionGemini(int[][] dots) {
    // 1. 초기값을 설정합니다 (x, y의 최소/최대값을 찾기 위해)
    int minX = dots[0][0];
    int maxX = dots[0][0];
    int minY = dots[0][1];
    int maxY = dots[0][1];

    // 2. 모든 점을 확인하며 최소/최대값을 갱신합니다.
    for (int i = 1; i < dots.length; i++) {
        minX = Math.min(minX, dots[i][0]);
        maxX = Math.max(maxX, dots[i][0]);
        minY = Math.min(minY, dots[i][1]);
        maxY = Math.max(maxY, dots[i][1]);
    }

    // 3. 가로 * 세로 계산
    int width = maxX - minX;
    int height = maxY - minY;

    return width * height;
}
}
