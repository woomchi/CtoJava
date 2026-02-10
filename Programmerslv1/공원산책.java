package Programmerslv1;

import java.util.StringTokenizer;

class 공원산책 {
    // 나의 풀이
    // w 실수 => 하드 코딩의 단점 : 실수가 남
    // 가독성 면에서 StringTokenizer와 if - else 문은 안좋음
    public int[] solution(String[] park, String[] routes) {
        int w = park[0].length();
        int h = park.length;

        int x = -1;
        int y = -1;
        for(int i = 0 ; i < h ; i++){
            if(park[i].contains("S")){
                x = park[i].indexOf("S");
                y = i;
                break;
            }
        }

        for(int i = 0 ; i < routes.length ; i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());

            for(int j = 1 ; j <= distance ; j++){
                if(direction.equals("S")){
                    if(y+j >= h || park[y+j].charAt(x) == 'X') break;
                    if(j == distance){
                        y += distance;
                    }
                }else if(direction.equals("N")){
                    if(y-j < 0 || park[y-j].charAt(x) == 'X') break;
                    if(j == distance){
                        y -= distance;
                    }
                }else if(direction.equals("E")){
                    if(x+j >= w || park[y].charAt(x+j) == 'X') break;
                    if(j == distance){
                        x += distance;
                    }
                }else if(direction.equals("W")){
                    if(x-j < 0 || park[y].charAt(x-j) == 'X') break;
                    if(j == distance){
                        x -= distance;
                    }
                }
            }

        }

        int[] answer = { y, x };
        return answer;
    }

    // Gemini 개선 풀이 - 델타 탐색
    // 각 조건을 분리함
    // 지나가는 지점의 X 여부를 dx , dy 1 단위로 이동시키며 확인시킴과 동시에 boolean 변수로 가능 여부 확인
    public int[] solutionGemini(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        int startY = 0;
        int startX = 0;

        // 1. 시작점 찾기
        for(int i = 0; i < h; i++){
            if(park[i].contains("S")){
                startY = i;
                startX = park[i].indexOf("S");
                break;
            }
        }
        
        // 현재 위치
        int y = startY;
        int x = startX;

        // 2. 방향 정의 (N, S, W, E 순서 - map과 매칭하거나 switch문 사용)
        // 여기서는 직관적인 switch문 사용 예시를 보여드립니다.
        
        for(String route : routes){
            String[] parts = route.split(" ");
            String op = parts[0];
            int n = Integer.parseInt(parts[1]);

            int dy = 0;
            int dx = 0;

            // 이동 방향 설정
            if(op.equals("N")) dy = -1;
            else if(op.equals("S")) dy = 1;
            else if(op.equals("W")) dx = -1;
            else if(op.equals("E")) dx = 1;

            int curY = y;
            int curX = x;
            boolean possible = true;

            // 3. 한 칸씩 이동하며 검증
            for(int i = 0; i < n; i++){
                int nextY = curY + dy;
                int nextX = curX + dx;

                // 범위 체크 (수정된 부분: y는 h와, x는 w와 비교)
                if(nextY < 0 || nextY >= h || nextX < 0 || nextX >= w || park[nextY].charAt(nextX) == 'X'){
                    possible = false;
                    break;
                }
                curY = nextY;
                curX = nextX;
            }

            // 4. 이동이 모두 유효하다면 실제 위치 업데이트
            if(possible){
                y = curY;
                x = curX;
            }
        }

        return new int[]{y, x};
    }
}