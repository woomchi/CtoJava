package 프로그래머스lv1;

import java.util.*;

public class 완주하지못한선수 {
    /* 핵심 로직 : Map.Entry 객체를 순회하며 데이터 다루기 */

    // 나의 풀이
    // List로 만들어봤지만, HashMap을 어떻게 활용해야할 지 모르겠어서 다른 코드 참고함
    public String solution(String[] participant, String[] completion) {
        // 완주하지 못한 사람의 이름 반환
        // 동명이인이 있을 수 있음
        String answer = "";
        HashMap<String, Integer> p_map = new HashMap<>();
        for(String p : participant){
            p_map.put(p, p_map.getOrDefault(p, 0)+1);
        }
        
        for(String c : completion){
            if(p_map.containsKey(c) && p_map.get(c) > 0){
                p_map.replace(c, p_map.get(c)-1);
            }
        }
        
        for(String k : p_map.keySet()){
            if(p_map.get(k) != 0){
                answer = k;
                break;
            }
        }
        
        return answer;
    }

    // keySet 대신 entrySet 활용
    public String solutionEntrySet(String[] participant, String[] completion) {
        // 완주하지 못한 사람의 이름 반환
        // 동명이인이 있을 수 있음
        String answer = "";
        HashMap<String, Integer> p_map = new HashMap<>();
        for(String p : participant){
            p_map.put(p, p_map.getOrDefault(p, 0)+1);
        }
        
        for(String c : completion){
            if(p_map.containsKey(c) && p_map.get(c) > 0){
                p_map.put(c, p_map.get(c)-1);
            }
        }
        
        for(Map.Entry<String, Integer> k : p_map.entrySet()){
            if(k.getValue() != 0){
                answer = k.getKey();
                break;
            }
        }
        
        return answer;
    }
}
