package 백준;
import java.io.*;
import java.util.*;

class 숫자카드2{
    // 불필요하게 메모리를 많이 차지하는 long을 사용함
    // HashMap도 효율이 좋지만, 계수 정렬이 특정 임의 인덱스로 접근하여 값을 찾기에 훨씬 빠름
    // 또한, 계수 정렬 뿐만 아니라 이분 탐색 방법도 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            long num = Long.parseLong(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            long num = Long.parseLong(st.nextToken());
            bw.write(map.getOrDefault(num,0)+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // Gemini 개선 풀이 - 계수 정렬
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        // 문제 범위가 -10,000,000 ~ 10,000,000 이므로
        // 인덱스 음수를 방지하기 위해 10,000,000을 더해줌 (배열 크기 약 2천만)
        int[] count = new int[20000001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(st.nextToken());
            count[num + 10000000]++; // 인덱스 보정
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        // StringBuilder를 쓰면 BufferedWriter보다 문자열 조합이 조금 더 직관적일 수 있음 (선택사항)
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(count[num + 10000000]).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    // Gemini 개선 풀이 - 이분탐색
    public static void solutionGemini1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 1. 가지고 있는 카드 입력 및 정렬
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 이분 탐색을 위한 필수 조건: 정렬
        Arrays.sort(arr);
        
        // 2. 찾아야 할 숫자 입력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            
            // 상한선 - 하한선 = 해당 숫자의 개수
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
    // Lower Bound: key 이상의 값이 처음 나오는 위치
    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            
            // key가 mid 위치의 값보다 작거나 같으면
            // 왼쪽 부분(포함)을 탐색해야 하므로 hi를 mid로 당김
            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    // Upper Bound: key를 초과하는 값이 처음 나오는 위치
    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            
            // key가 mid 위치의 값보다 작으면 (key < arr[mid])
            // 즉, arr[mid]가 key보다 크다면, mid는 상한선의 후보가 됨
            if (key < arr[mid]) {
                hi = mid;
            } else {
                // key >= arr[mid] 인 경우, 오른쪽을 봐야 함
                lo = mid + 1;
            }
        }
        return lo;
    }
}