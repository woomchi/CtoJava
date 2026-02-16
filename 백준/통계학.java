package 백준;
import java.io.*;
import java.util.Arrays;

class 통계학{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int [] val = new int[N];
        for(int i = 0 ; i < N ; i++){
            val[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(val);
        double avg = 0;
        for(int i = 0 ; i < N ; i++){
            avg += val[i];
        }
        System.out.println(Math.round(avg/N));

        int mid = val[N/2];
        System.out.println(mid);

        int[] count = new int[8001];
        int maxFreq = 0;
        
        for(int i = 0; i < N; i++) {
            int idx = val[i] + 4000;
            count[idx]++;
            
            if(count[idx] > maxFreq) {
                maxFreq = count[idx];
            }
        }

        int mode = 0;
        boolean flag = false;
        for(int i = 0; i <= 8000; i++) {
            if(count[i] == maxFreq) {
                if(!flag) {
                    mode = i - 4000;
                    flag = true;
                }
                else {
                    mode = i - 4000;
                    break;
                }
            }
        }
        System.out.println(mode);

        int range = val[N-1] - val[0];
        System.out.println(range);        
        br.close();
    }
}