package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 커트라인 {
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        List<Integer> list = new ArrayList<>(N);
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        System.out.println(list.get(k-1));
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 1. ArrayList 대신 기본형 배열 사용 (메모리/속도 최적화)
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. 오름차순 정렬 (기본 정렬이 Comparator 사용보다 빠름)
        Arrays.sort(arr);
        
        // 3. 오름차순 상태에서 k번째로 큰 수는 뒤에서 k번째 (인덱스: N - k)
        // 예: 1 2 3 4 5 에서 2번째 큰 수(4)는 인덱스 5-2 = 3
        System.out.println(arr[N - k]);
        
        br.close();
    }
}
