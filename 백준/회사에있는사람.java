package 백준;
import java.io.*;
import java.util.*;

class 회사에있는사람{
    // 나의 풀이
    // 성능면에서 HashSet이 TreeSet보다 좋기 때문에 선택을 잘함
    // 만약 중간 중간 저ㅇ렬 상태에서 값을 확인해야하면 TreeSet이적절함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if(state.equals("enter")){
                set.add(name);
            }else{
                if(set.contains(name)){
                    set.remove(name);
                }
            }    
        }
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String n : list){
            sb.append(n).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // HashSet 사용 (O(1) 검색/삭제)
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            
            if(state.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name); // if(contains) 체크 없이 바로 삭제 시도
            }    
        }
        
        // 정렬을 위해 리스트로 변환
        List<String> list = new ArrayList<>(set);
        // 역순 정렬
        list.sort(Collections.reverseOrder()); // Java 8 이상에서는 List.sort 권장

        StringBuilder sb = new StringBuilder();
        for(String n : list) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}