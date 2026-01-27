package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class AB7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            sb.append("Case #").append(i).append(": ").append(A+B).append("\n");
            
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
