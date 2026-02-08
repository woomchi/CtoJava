package 백준;
import java.io.*;
import java.util.*;

class 단어정렬{
    // 나의 풀이
    // 어차피 sort로 정렬하기 때문에 TreeSet보다 HashSet이 효율적임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>();
        for(int i = 0 ; i < N ; i++){
            set.add(br.readLine());
        }
        
        String[] str = set.toArray(new String [0]);
        Arrays.sort(str, Comparator.comparing((String s) -> s.length()).thenComparing((s) -> s));
        
        for(int i = 0 ; i < set.size() ; i++){
            bw.write(str[i]);
            bw.newLine();
        }
            
        bw.flush();
        br.close();
        bw.close();
    }

    // 나의 리펙터링
    public static void solution1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        
        for(String s : list){
            bw.write(s);
            bw.newLine();
        }
            
        bw.flush();
        br.close();
        bw.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>();
        for(int i = 0 ; i < N ; i++){
            set.add(br.readLine());
        }
        
        String[] str = set.toArray(new String [0]);
        Arrays.sort(str, Comparator.comparingInt(String::length) // int 최적화
        .thenComparing(Comparator.naturalOrder()));
        
        for(int i = 0 ; i < set.size() ; i++){
            bw.write(str[i]);
            bw.newLine();
        }
            
        bw.flush();
        br.close();
        bw.close();
    }
}