package 백준;
import java.io.*;
import java.util.*;

class 최소공배수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        System.out.println((A * B) / getGCD(A, B));
        br.close();
    }

    static long getGCD(long a, long b){
        while(b != 0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}