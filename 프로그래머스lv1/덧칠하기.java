package 프로그래머스lv1;

class 덧칠하기{
    // 나의 풀이
    // for문은 단순히 순회하고 조건 판단은 별도의 변수가 해야함
    public int solution(int n, int m, int[] section) {
        int len = section.length;
        int maxPos = section[len-1];
        int answer = 0;
        if(n <= m)  return 1;
        for(int i = 0 ; i < len-1 ; i++){
            for(int j = i+1 ; j < len ; j++){
                if(section[i]+m-1 < section[j]){
                    if(maxPos == section[j])    answer++;
                    answer++;
                    i = j;
                }else{
                    if(i == len -2){
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    // Gemini 개선 풀이
    public int solutionGemini(int n, int m, int[] section) {
    int answer = 0;
    int rollerEnd = 0; // 롤러가 칠해진 마지막 위치를 저장

    for (int part : section) {
        // 현재 구역(part)이 롤러가 칠해진 범위보다 오른쪽에 있다면 (아직 안 칠해짐)
        if (part > rollerEnd) {
            answer++; // 칠하기 횟수 증가
            rollerEnd = part + m - 1; // 현재 구역부터 롤러 길이만큼 칠함
        }
    }

    return answer;
}
}