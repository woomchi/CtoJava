package 백준;
import java.io.*;
import java.util.*;

class 영단어암기는괴로워{
    // 나의 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            if(str.length() >= M){
                map.put(str, map.getOrDefault(str, 0)+1);
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (s1, s2) -> {
            if(map.get(s1) != map.get(s2)){
                return map.get(s2) - map.get(s1);
            }
            if(s1.length() != s2.length()){
                return s2.length() - s1.length();
            }
            return s1.compareTo(s2);
        });
        for(String s : list){
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
    
    // Gemini 개선 풀이
}