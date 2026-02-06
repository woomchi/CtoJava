package 백준;
import java.io.*;
import java.util.*;

class 숫자카드{
    // 나의 풀이
    // HashMap대신 HashSet을 사용하는게 가독성 측면에서 더 좋음
    // flush를 반복문에서 매번 출력시키면 그만큼 연산이 발생하므로 비효율적 => 한 번에 출력시키기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                bw.write(1+" ");
            }else{
                bw.write(0+" ");
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }

    // 나의 리펙터링 - 이분 탐색 피드백 수용
    public static void solution1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(arr, num) >= 0){
                bw.write("1 ");
            }else{
                bw.write("0 ");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    // Gemini 개선 풀이 - HashSet 활용
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 최적화 1: Value가 필요 없으므로 HashSet 사용
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                bw.write("1 "); // 문자열 결합보다 리터럴 문자열이 아주 미세하게 더 빠름
            }else{
                bw.write("0 ");
            }
            // 중요: 여기서 flush()를 하지 않습니다!
        }
        
        bw.flush(); // 중요: 모든 출력을 모아서 마지막에 한 번만 전송
        bw.close();
        br.close();
    }
}