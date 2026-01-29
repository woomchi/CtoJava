package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String str = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        long sum = 0;
        for(int i = 0 ; i < str.length() ; i++){
           char c = str.charAt(i);
           if('a' <= c && c <= 'z'){
               sum += (c-55) * Math.pow(N,str.length()-1-i);
           }else if('0' <= c && c <= '9'){
               sum += (c-48) * Math.pow(N,str.length()-1-i);
           }
        }
        System.out.println(sum);
    }
}
