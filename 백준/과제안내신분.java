package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class 과제안내신분 {
    // 나의 풀이
    // TreeSet으로 정렬된 상태로 다루는 것은 좋음
    // 하지만, boolean은 크기와 탐색 면에서 메모리와 효율 측면에서 좋음
    public static void main(String[] args) throws IOException{
        final int attend = 28;
        final int total = 30;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < attend; i++){
            set.add(Integer.parseInt(br.readLine()));
        }
        
        int minNum = 0;
        int nextNum = 0;
        for(int i = 1; i <= total; i++){
            if(!set.contains(i)){
                if(minNum == 0){
                    minNum = i;
                }else{
                    nextNum = i;
                }
            }
        }
        System.out.println(minNum+"\n"+nextNum);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        // 1번부터 30번까지 사용하므로 크기를 31로 잡으면 인덱스 계산이 편합니다.
        boolean[] submitted = new boolean[31];
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 28; i++) {
                int num = Integer.parseInt(br.readLine());
                submitted[num] = true; // 제출한 번호 체크
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) { // 체크되지 않은 번호(false)가 과제 안 낸 사람
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);

    }
}