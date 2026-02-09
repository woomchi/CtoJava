package 프로그래머스lv1;

public class 바탕화면정리 {
    /* 핵심 로직 : 반전된 x축과 y축 */

    // 나의 풀이
    // 최대 최소값은 왠만하면 MAX_VALUE와 MIN_VALUE로 하기
    class Solution {
        public int[] solution(String[] wallpaper) {
            int width = wallpaper[0].length();
            int height = wallpaper.length;
            int lux = 51;
            int luy = 51;
            int rdx = 0;
            int rdy = 0;

            for(int i = 0 ; i < height ; i++){
                for(int j = 0 ; j < width ; j++){
                    if(wallpaper[i].charAt(j) == '#'){
                        lux = Math.min(lux, i);
                        luy = Math.min(luy, j);
                        rdx = Math.max(rdx, i+1);
                        rdy = Math.max(rdy, j+1);
                    }
                }
            }

            int[] answer = { lux, luy, rdx, rdy };
            return answer;
        }
    }

    // Gemini 개선 풀이
    public int[] solution(String[] wallpaper) {
        // 초기값 설정: 최소값은 가장 큰 수로, 최대값은 가장 작은 수로 초기화
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int height = wallpaper.length;
        int width = wallpaper[0].length();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    // 파일이 있는 위치에서 가장 상단(minX), 좌측(minY) 좌표 갱신
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    
                    // 파일이 있는 위치에서 가장 하단(maxX), 우측(maxY) 좌표 갱신
                    // 드래그 범위는 해당 칸을 포함해야 하므로 +1
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                }
            }
        }

        return new int[]{minX, minY, maxX, maxY};
    }
}
