package 백준;
import java.io.*;
import java.util.*;

class 나는야포켓몬마스터{
    // 나의 풀이
    // Hash 충돌 위험
    // 문자 인지 숫자 인지 구별하지 않으면 런타임 에러 발생함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            String pokemon = br.readLine();
            map1.put(pokemon, String.valueOf(i+1));
            map2.put(String.valueOf(i+1), pokemon);
        }
        
        for(int i = 0 ; i < M ; i++){
            String input = br.readLine();
            if(map1.containsKey(input)){
                bw.write(map1.get(input));
            }else if(map2.containsKey(input)){
                bw.write(map2.get(input));
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // Gemini 개선 풀이
    // Hash 충돌 방지를 위해 이름은 인덱스로써 받은 숫자로 임의 접근하여 찾음
    // 번호는 String,Integer로 순회하지 않고 바로 찾음
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 1. 이름으로 번호를 찾을 때는 HashMap 사용
        HashMap<String, Integer> nameMap = new HashMap<>();
        // 2. 번호로 이름을 찾을 때는 배열 사용 (인덱스 접근이 훨씬 빠름)
        String[] nameArr = new String[N + 1];
        
        for(int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            nameMap.put(pokemon, i);
            nameArr[i] = pokemon;
        }
                
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            
            // 3. 입력값의 첫 글자가 숫자인지 확인하여 분기 처리
            if(Character.isDigit(input.charAt(0))) {
                // 숫자면 배열에서 이름 찾기 (O(1))
                int index = Integer.parseInt(input);
                bw.write(nameArr[index]);
            } else {
                // 문자면 맵에서 번호 찾기 (O(1))
                bw.write(String.valueOf(nameMap.get(input)));
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}