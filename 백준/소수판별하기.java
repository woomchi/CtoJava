package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 소수판별하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(N+1);
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Collections.max(list);
        boolean[] isPrime = new boolean[M+1];
        for(int i = 2 ; i < M+1 ; i++)  isPrime[i] = true;

        for(int i = 2 ; i <= Math.sqrt(M) ; i++){
            if(isPrime[i]){
                for(int j = i * i ; j <= M; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        for(int i : list){
            if(isPrime[i])    count++;    
        }

        System.out.println(count);
        br.close();
    }
}
