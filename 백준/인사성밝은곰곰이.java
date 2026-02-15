package 백준;
import java.io.*;
import java.util.*;

class 인사성밝은곰곰이{
    // 나의 풀이
    // 불필요한 isEnter 제거 필요
    // 메서드를 활용한 로직 간소화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        boolean isEnter = false;
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                count += set.size();
                isEnter = true;
                set = new HashSet<>();
            }else{
                if(isEnter){
                    set.add(str);
                }
            }
        }
        count += set.size();
        System.out.println(count);
        br.close();
    }

    // Gemini 개선 풀이
    public static void solutionGemini(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            
            if (str.equals("ENTER")) {
                // ENTER를 만나면 새로운 곰곰이 입장이므로 집합 초기화
                set.clear();
            } else {
                // set.add()는 값이 이미 존재하면 false, 처음이면 true를 반환합니다.
                // 이를 이용하면 별도의 size 더하기 로직 없이 즉시 카운팅이 가능합니다.
                if (set.add(str)) {
                    count++;
                }
            }
        }
        
        // 루프 밖에서 추가 처리가 필요 없어짐
        System.out.println(count);
        br.close();
    }
}