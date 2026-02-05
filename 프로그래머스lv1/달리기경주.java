package 프로그래머스lv1;

import java.util.HashMap;

public class 달리기경주 {
    // 피드백을 토대로 짠 코드
    // 애초에 등수를 반환하지 않기 때문에 통일성을 위해 i+1 대신 i로 저장하는게 좋음
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < players.length ; i++)   map.put(players[i], i+1);

        for(String c : callings){
            int rank = map.get(c);
            String temp = players[rank-2];
            players[rank-2] = players[rank-1];
            players[rank-1] = temp;
            map.put(c, rank-1);
            map.put(temp, rank);
        }

        return players;
    }
}
