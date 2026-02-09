package 프로그래머스lv1;

import java.util.Arrays;

public class 공원 {
    /* 핵심 로직 : 완전 탐색 */

    // 나의 풀이
    // 완전 탐색 방법으로 잘 해결했지만 가독성이 떨어짐 => 메서드 분리
    // 오름차순으로 찾으면 찾는 시간이 더 오래걸리므로 가장 큰 돗자리부터 찾아 처음 발견한 것을 반환하면 됨
    public int solution(int[] mats, String[][] park) {
        // 14:35
        // 가지고 있는 돗자리 중에 사용할 수 있는 최대 크기 돗자리 반환
        // 돗자리 설치 가능 구역 확인
        // S 와 E 구하기
        // true : 이미 차지한 구역 false: 빈 구역
        int width = park[0].length;
        int height = park.length;

        Arrays.sort(mats);
        int maxMat = Integer.MIN_VALUE;
        for(int k = 0 ; k < mats.length ; k++){
            int matLen = mats[k];
            for(int j = 0 ; j < width-matLen+1 ; j++){
                for(int i = 0 ; i < height-matLen+1 ; i++){
                    boolean isPossible = true;
                    for(int l = i ; l < i+matLen ; l++){
                        for(int p = j ; p < j+matLen ; p++){
                            if(!park[l][p].equals("-1")){
                                isPossible = false;
                                break;
                            }
                        }
                        if(!isPossible)  break;
                    }
                    if(isPossible){
                        maxMat = Math.max(maxMat, matLen);
                    }
                }
            }
        }
        if(maxMat == Integer.MIN_VALUE)   maxMat = -1;
        return maxMat;
    }

    // Gemini 개선 풀이
    public int solutionGemini(int[] mats, String[][] park) {
        int width = park[0].length;
        int height = park.length;

        // 1. 돗자리를 오름차순 정렬 (작은 것 -> 큰 것)
        Arrays.sort(mats);

        // 2. 큰 돗자리부터 역순으로 탐색 (중요: 효율성 개선)
        for (int k = mats.length - 1; k >= 0; k--) {
            int matLen = mats[k];

            // 3. 해당 크기의 돗자리가 놓일 수 있는 모든 위치 탐색
            for (int r = 0; r <= height - matLen; r++) {
                for (int c = 0; c <= width - matLen; c++) {
                    
                    // 해당 위치에 돗자리 설치 가능한지 확인
                    if (canPlaceMat(park, r, c, matLen)) {
                        return matLen; // 가장 큰 것을 찾았으므로 즉시 반환 (조기 종료)
                    }
                }
            }
        }

        // 설치 가능한 돗자리가 없는 경우
        return -1;
    }

    // 4. 가독성을 위해 검사 로직을 별도 메서드로 분리
    private boolean canPlaceMat(String[][] park, int startRow, int startCol, int size) {
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                // "-1"이 아닌 곳(알파벳 등)이 있으면 설치 불가
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
