package 프로그래머스lv1;

import java.util.StringTokenizer;

public class 동영상재생기 {
    /* 핵심 로직 : 메서드 활용 */

    // 나의 풀이
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 15:30
        final int element_num = 4;
        String[] replaceTime = new String[element_num];
        replaceTime[0] = video_len;
        replaceTime[1] = pos;
        replaceTime[2] = op_start;
        replaceTime[3] = op_end;

        // 0 : 영상 길이 | 1 : 위치 | 2 : 오프닝시작 | 3 : 오프닝 끝
        int [] time = new int[element_num];
        for(int i = 0 ; i < element_num ; i++){
            StringTokenizer st = new StringTokenizer(replaceTime[i], ":");
            time[i] = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < commands.length ; i++){
            if(time[2] <= time[1] && time[1] < time[3]) time[1] = time[3];

            String cmd = commands[i];
            if(cmd.equals("next")){
                time[1] += 10;
            }else if(cmd.equals("prev")){
                time[1] -= 10;
            }

            if(time[2] <= time[1] && time[1] < time[3]){
                time[1] = time[3];
            }else if(time[1] < 0){
                time[1] = 0;
            }else if(time[0] < time[1]){
                time[1] = time[0];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", time[1]/60)).append(":").append(String.format("%02d", time[1]%60));

        String answer = sb.toString();
        return answer;
    }

    // Gemini 개선 풀이 - 메서드 활용
    public String solutionGemini(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 1. 가독성을 위해 개별 변수로 변환 및 저장
        int videoLenSec = parseTime(video_len);
        int posSec = parseTime(pos);
        int opStartSec = parseTime(op_start);
        int opEndSec = parseTime(op_end);

        // 2. 초기 위치가 오프닝 구간일 수 있으므로 선제적 체크
        posSec = skipOpening(posSec, opStartSec, opEndSec);

        for (String command : commands) {
            if (command.equals("next")) {
                posSec += 10;
                // 영상 끝을 넘어가면 영상 길이로 고정 (Math.min 활용)
                posSec = Math.min(posSec, videoLenSec); 
            } else {
                posSec -= 10;
                // 0초 미만이면 0초로 고정 (Math.max 활용)
                posSec = Math.max(posSec, 0); 
            }

            // 이동 후 오프닝 구간 체크
            posSec = skipOpening(posSec, opStartSec, opEndSec);
        }

        return String.format("%02d:%02d", posSec / 60, posSec % 60);
    }

    // 오프닝 건너뛰기 로직 분리
    private int skipOpening(int current, int start, int end) {
        if (current >= start && current < end) {
            return end;
        }
        return current;
    }

    // 시간 변환 로직 분리 (String -> int)
    private int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
