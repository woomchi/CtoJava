package 백준;
import java.io.*;
import java.util.*;

class 가로수{
    // Gemini 조언에 따른 수정된 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] trees = new long[N];
        for(int i = 0 ; i < N ; i++){
            long pos = Long.parseLong(br.readLine());
            trees[i] = pos;
        }
        Arrays.sort(trees);

        // 핵심 수정: 첫 번째 간격으로 gcd 초기화
        long gcd = trees[1] - trees[0];

        // 두 번째 간격부터 끝까지 순회하며 GCD 누적
        for(int i = 1; i < N - 1; i++){
            long distance = trees[i+1] - trees[i];
            gcd = getGcd(distance, gcd);
        }

        // 전체 필요한 나무 수 - 이미 심어진 나무 수(N)
        long totalCount = (trees[N-1] - trees[0]) / gcd + 1;
        System.out.println(totalCount - trees.length);
        br.close();
    }

    public static long getGcd(long a, long b){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}