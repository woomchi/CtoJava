package 백준;
import java.io.*;
import java.util.*;

class 바구니뒤집기{
    // 나의 풀이
    // 인덱스 표현이 복잡하여 가독성이 떨어짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = i+1;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            reverse(arr, start, end);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(a).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
    
    public static void reverse(int [] arr, int start, int end){
        for(int j = 0 ; j < (end-start+1)/2 ; j++){
            int temp = arr[start+j];
            arr[start+j] = arr[end-j];
            arr[end-j] = temp;
        }
    }

    // Gemini 개선 풀이
    // 시작점과 끝점 자체를 투 포인터로 사용하여 직관적인 코드로 개선됨
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            reverse1(arr, start, end);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
    
    // 
    // 투 포인터 방식을 사용하여 가독성 향상
    public static void reverse1(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
}