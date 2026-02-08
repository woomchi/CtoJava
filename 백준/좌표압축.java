package 백준;
import java.io.*;
import java.util.*;

class 좌표압축{
    // 나의 풀이
    // 과도한 컬렉션 클래스 사용으로 빈번한 박싱으로 인해 오버헤드 발생
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(N);
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        TreeSet<Integer> set = new TreeSet<>(list);
        int len = set.size();
        HashMap<Integer, Integer> order = new HashMap<>();
        for(int i = 0 ; i < len ; i++){
            order.put(set.pollFirst(), i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++){
            sb.append(order.get(list.get(i))).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    // Gemini 개선 풀이
    // 배열로 저장 후, 중복 제거
    // 오름차순 정렬 후 HashMap 저장
    // Collections.binarySearch로 값 탐색
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 1. 원본 배열 저장 (int[] 사용으로 메모리 절약)
        int[] origin = new int[N];
        int[] sorted = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. 정렬 (O(N log N))
        Arrays.sort(sorted);
        
        // 3. 중복 제거 (HashMap 대신 배열 인덱싱 활용)
        // sorted 배열을 순회하며 중복되지 않은 값만 temp 배열에 담거나 
        // HashMap을 사용하여 (값 -> 순위)를 매핑합니다.
        // 여기서는 HashMap을 쓰되, int[] 기반이라 훨씬 빠릅니다.
        
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for(int v : sorted) {
            // 이미 순위가 매겨진 값이면 스킵
            if(!rankMap.containsKey(v)) {
                rankMap.put(v, rank);
                rank++;
            }
        }
        
        // 4. 출력 구성
        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            sb.append(rankMap.get(key)).append(' ');
        }
        
        System.out.println(sb);
    }
}