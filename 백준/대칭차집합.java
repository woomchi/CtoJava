package 백준;
import java.io.*;
import java.util.*;

class 대칭차집합{
    // 나의 풀이
    // 메모리 절약과 불필요한 순회 제거가 필요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<Long, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            long num = Long.parseLong(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int result = 0;
        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result++;
            }
        }
        
        System.out.println(result);
        br.close();
    }

    // Gemini 개선 풀이
    public static void soltuionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 메모리 절약을 위해 HashSet 사용 (Key만 저장하므로 Map보다 가벼움)
        HashSet<Integer> setA = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        
        int intersectionCount = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 입력받은 B의 원소가 A에 있다면 교집합임
            if(setA.contains(num)) {
                intersectionCount++;
            }
        }
        
        // 대칭 차집합의 개수 = (A 크기 + B 크기) - 2 * (교집합 크기)
        System.out.println(N + M - 2 * intersectionCount);
        br.close();
    }
}