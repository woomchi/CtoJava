package 프로그래머스lv0;

public class 외계어사전 {
    // 나의 풀이
    // 중복된 단어에서 길이가 다르다고 판명되므로 잘못된 의도
    // => 문제 의도를 잘못 파악해서 논리적 오류가 발생할 가능성이 생김
    public int solution(String[] spell, String[] dic) {
        int count = 0;
        for(String d : dic){
            for(String s : spell){
                if(d.contains(s))   count++;
            }
            if(count==spell.length) return 1;
            count = 0;
        }
        return 2;
    }
    
    //Gemini 개선 풀이
    public int solutionGemini(String[] spell, String[] dic) {
        for(String d : dic){
            // 1. 먼저 길이부터 확인 (다르면 바로 다음 단어로 넘어감)
            if(d.length() != spell.length) continue; 
            
            int count = 0;
            for(String s : spell){
                if(d.contains(s)) count++;
            }
            
            // 2. 길이가 같고, 모든 spell 문자가 포함되어 있다면 정답
            if(count == spell.length) return 1;
        }
        return 2;
    }
}
