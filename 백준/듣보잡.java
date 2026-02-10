package 백준;
import java.io.*;
import java.util.*;

class 듣보잡{
    // 나의 풀이
    // bw vs sb
    // HashSet도 초기 용량을 설정할 수 있음???? !!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashSet<String> notHeard = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            notHeard.add(br.readLine());
        }
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            String name = br.readLine();
            if(notHeard.contains(name)){
                list.add(name);
            }
        }
        Collections.sort(list);
        bw.write(""+list.size());
        bw.newLine();
        for(String nhs : list){
            bw.write(nhs);
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}