package 백준;
import java.util.*;
import java.io.*;

class 최댓값{
    // 나의 문제 풀이
    // if문으로 최대값을 확인하기 때문에 굳이 max를 사용할 필요없음
    // maxValue의 초기값은 안전하게 Integer.MIN_VALUE를 하거나 -1와 같이 불가능한 숫자를 넣어야함
    // 그리고 성능면에서는 박싱 래퍼 클래스를 valueOf보다 parseInt가 나음
    public static void main(String[] args) throws IOException{
        final int row = 9;
        final int col = 9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxValue = 0;
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0;i<row;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++){
                int val = Integer.valueOf(st.nextToken());
                if(maxValue <= val){
                    maxRow = i+1;
                    maxCol = j+1;
                }
                maxValue = Math.max(val, maxValue);
            }
        }
        System.out.print(maxValue + "\n" + maxRow + " " + maxCol);
    }

    // Gemini의 개선 풀이
    public static void solution(String[] args) throws IOException {
        final int ROW = 9;
        final int COL = 9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int maxValue = -1; // 입력이 0 이상이라면 -1로 시작하는 것이 안전
        int maxRow = 1;
        int maxCol = 1;

        for (int i = 0; i < ROW; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                int val = Integer.parseInt(st.nextToken()); // parseInt 사용 권장
                
                // 최댓값이 발견되면 좌표와 값을 동시에 갱신
                if (val > maxValue) {
                    maxValue = val;
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }
        
        // StringBuilder를 사용하면 출력 속도가 더 빨라집니다 (데이터가 많을 때 유용)
        System.out.println(maxValue);
        System.out.println(maxRow + " " + maxCol);
    }
}