package 프로그래머스lv1;
import java.util.*;

class 실패율 {
    // 나의 풀이
    // 이중 반복문을 사용하여 시간 복잡도 N^2로 높음
    // 그리고 Map에 인덱스와 함께 값을 저장하고 실패율을 따로 정렬하여 비교하는 동기화 방식은 복잡하고 정확성에 대한 위험이 존재함
    public int[] solution(int N, int[] stages) {
        double[] reached = new double[N+1];
        int[] failed = new int[N+1];
        for(int i = 0 ; i < stages.length; i++){
            int end = stages[i];
            if(stages[i] == N+1)    end = N;
            for(int j = 1 ; j <= end; j++){
                reached[j]++;
            }
            if(stages[i] <= N)  failed[stages[i]]++;
        }

        // 내림차순으로 정렬하고 실패율이 같은 인덱스번호를 부여
        List<Double> list = new ArrayList<>(N);
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 1 ; i < N+1; i++){
            double element;
            if(reached[i] != 0){
                element = failed[i] / reached[i];
            }else{
                element = 0;
            }

            list.add(element);
            map.put(i,element);
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // 실패율과 동일한 값의 인덱스 키를 저장
        int[] answer = new int[N];
        for(int i = 0 ; i < N ; i++){  
            double fail = list.remove(0);
            for(int j = 1 ; j < N+1; j++){
                if(fail == map.get(j)){
                    System.out.println(j);
                    answer[i] = j;
                    map.replace(j, -1.0);
                    break;
                }
            }
        }

        return answer;
    }

    // Gemini 개선 풀이
    // 중첩 클래스를 Comparable과 함께 선언 및 구현하여 이중 반복문 구조를 제거함
    // 총 스테이지에 존재하는 사람 중에서 기본 실패율을 0으로 정의하고 각 층의 실패한 수를 뺌으로써 NaN에 대한 걱정이 없음
    // 각 스테이지 정보와 실패율을 한 번에 저장하고 있기 때문에 동기화에 대한 걱정이 없고
    // 관리가 용이함
    class Stage implements Comparable<Stage> {
        int id;
        double failureRate;

        public Stage(int id, double failureRate) {
            this.id = id;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            // 실패율 내림차순 정렬
            if (o.failureRate < this.failureRate) {
                return -1;
            } else if (o.failureRate > this.failureRate) {
                return 1;
            }
            // 실패율이 같으면 스테이지 번호 오름차순
            return this.id - o.id;
        }
    }

    public int[] solutionGemini(int N, int[] stages) {
        // 2. 스테이지별 머물러 있는 사용자 수 카운트 (O(M))
        // stages의 길이만큼만 순회하면 됨
        int[] currentStageCount = new int[N + 2];
        for (int stage : stages) {
            currentStageCount[stage]++;
        }

        // 3. 실패율 계산 (O(N))
        List<Stage> stageList = new ArrayList<>();
        int totalPlayers = stages.length; // 현재 스테이지에 도달한 남은 사람 수

        for (int i = 1; i <= N; i++) {
            int fail = currentStageCount[i]; // 해당 스테이지에 머물러 있는 사람(실패)
            double rate = 0;

            if (totalPlayers > 0) {
                rate = (double) fail / totalPlayers;
                // 다음 스테이지 도달 인원 = 현재 전체 인원 - 현재 스테이지 탈락 인원
                totalPlayers -= fail; 
            }
            // 도달한 사람이 0명이면 실패율 0 (문제 조건)

            stageList.add(new Stage(i, rate));
        }

        // 4. 정렬 (O(N log N))
        Collections.sort(stageList);

        // 5. 결과 변환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).id;
        }

        return answer;
    }
}