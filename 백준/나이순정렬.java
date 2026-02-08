package 백준;
import java.io.*;
import java.util.*;

class 나이순정렬{
    static class Member{
        int order;
        int age;
        String name;
        
        Member(int order, int age, String name){
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }
    
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Member> list = new ArrayList<>(N);
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Member m = new Member(i, age, name);
            list.add(m);
        }
        
        Collections.sort(list, Comparator.comparingInt((Member m) -> m.age)
                                         .thenComparingInt((Member m) -> m.order));
        
        StringBuilder sb = new StringBuilder();
        for(Member m : list){
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이
    static class Member1 {
        int age;
        String name;
        
        // order 필드 제거 (Java의 Sort는 입력 순서를 보장함)
        Member1(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Member1> list = new ArrayList<>(N);
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // 순서(i)를 넘기지 않아도 됨
            list.add(new Member1(age, name));
        }
        
        // 2. 나이 기준으로만 정렬 (나이가 같으면 입력 순서 유지됨 - Stable Sort)
        list.sort(Comparator.comparingInt(m -> m.age));
        
        StringBuilder sb = new StringBuilder();
        for(Member1 m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}