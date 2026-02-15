package 백준;
import java.io.*;
import java.util.*;

class 약수2{
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)    list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        
        System.out.println(list.get(0) * list.get(N-1));
        br.close();
    }

    // Gemini 개선 풀이 - 배열 활용
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 리스트 대신 배열 선언
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 배열 정렬
        System.out.println((long) arr[0] * arr[N-1]); // long으로 안전하게 출력
        br.close();
    }
}